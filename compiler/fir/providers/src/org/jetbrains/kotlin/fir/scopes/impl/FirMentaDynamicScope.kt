/*
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.scopes.impl

import org.jetbrains.kotlin.descriptors.EffectiveVisibility
import org.jetbrains.kotlin.descriptors.Modality
import org.jetbrains.kotlin.descriptors.Visibilities
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.FirSessionComponent
import org.jetbrains.kotlin.fir.caches.FirCache
import org.jetbrains.kotlin.fir.caches.createCache
import org.jetbrains.kotlin.fir.caches.firCachesFactory
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.declarations.FirNamedFunction
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.declarations.FirResolvePhase
import org.jetbrains.kotlin.fir.declarations.builder.buildNamedFunction
import org.jetbrains.kotlin.fir.declarations.builder.buildProperty
import org.jetbrains.kotlin.fir.declarations.builder.buildValueParameter
import org.jetbrains.kotlin.fir.declarations.impl.FirResolvedDeclarationStatusImpl
import org.jetbrains.kotlin.fir.moduleData
import org.jetbrains.kotlin.fir.resolve.ScopeSession
import org.jetbrains.kotlin.fir.scopes.DelicateScopeAPI
import org.jetbrains.kotlin.fir.scopes.FirTypeScope
import org.jetbrains.kotlin.fir.scopes.ProcessorAction
import org.jetbrains.kotlin.fir.symbols.impl.*
import org.jetbrains.kotlin.fir.types.builder.buildResolvedTypeRef
import org.jetbrains.kotlin.fir.types.impl.ConeClassLikeTypeImpl
import org.jetbrains.kotlin.fir.types.toLookupTag
import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.name.StandardClassIds

val MENTA_DYNAMIC_FQ_NAME: FqName = FqName("<menta-dynamic>")

val DYNAMIC_OBJECT_CLASS_ID: ClassId = ClassId(FqName("menta.dynamic"), Name.identifier("DynamicObject"))

/**
 * A scope wrapper that adds dynamic member resolution as a fallback.
 *
 * When a member lookup fails on the real class scope, this scope provides
 * synthetic pseudo-members tagged with [FirDeclarationOrigin.MentaDynamicScope].
 * These are later transformed into `tryGetMember`/`trySetMember`/`tryInvokeMember`
 * calls during FIR-to-IR conversion.
 */
class FirMentaDynamicScope(
    private val delegate: FirTypeScope,
    private val session: FirSession,
    private val scopeSession: ScopeSession,
) : FirTypeScope() {
    /**
     * Check if a member with the given name exists in the delegate scope (real members only).
     * This is useful to avoid routing to dynamic dispatch for members that are actually defined.
     */
    fun hasMemberInDelegate(name: Name): Boolean {
        var found = false
        delegate.processFunctionsByName(name) { found = true }
        if (!found) {
            delegate.processPropertiesByName(name) { found = true }
        }
        return found
    }
    override fun processDirectOverriddenFunctionsWithBaseScope(
        functionSymbol: FirNamedFunctionSymbol,
        processor: (FirNamedFunctionSymbol, FirTypeScope) -> ProcessorAction,
    ): ProcessorAction {
        if (functionSymbol.origin == FirDeclarationOrigin.MentaDynamicScope) {
            return ProcessorAction.NEXT
        }
        return delegate.processDirectOverriddenFunctionsWithBaseScope(functionSymbol, processor)
    }

    override fun processDirectOverriddenPropertiesWithBaseScope(
        propertySymbol: FirPropertySymbol,
        processor: (FirPropertySymbol, FirTypeScope) -> ProcessorAction,
    ): ProcessorAction {
        if (propertySymbol.origin == FirDeclarationOrigin.MentaDynamicScope) {
            return ProcessorAction.NEXT
        }
        return delegate.processDirectOverriddenPropertiesWithBaseScope(propertySymbol, processor)
    }

    override fun getCallableNames(): Set<Name> = delegate.getCallableNames()

    override fun getClassifierNames(): Set<Name> = delegate.getClassifierNames()

    override fun processFunctionsByName(
        name: Name,
        processor: (FirNamedFunctionSymbol) -> Unit,
    ) {
        var foundInDelegate = false
        delegate.processFunctionsByName(name) {
            foundInDelegate = true
            processor(it)
        }
        // Only create synthetic member if NOT found in the delegate (i.e., not actually defined)
        if (!foundInDelegate) {
            // But skip synthetic members for well-known stdlib/system functions
            // that should never be routed through dynamic dispatch
            val skipNames = setOf(
                "println", "print", "printlnStack", "TODO",
                "repeat", "apply", "also", "use", "with", "let", "run",
                "toString", "equals", "hashCode", "compareTo",
                "plus", "minus", "times", "div", "mod", // operators
                "iterator", "next", "hasNext", "get", "set", "invoke"
            )
            if (name.identifier !in skipNames) {
                val syntheticFn = session.mentaDynamicMembersStorage.functionsCacheByName.getValue(name, null)
                processor(syntheticFn.symbol)
            }
        }
    }

    override fun processPropertiesByName(
        name: Name,
        processor: (FirVariableSymbol<*>) -> Unit,
    ) {
        var foundInDelegate = false
        delegate.processPropertiesByName(name) {
            foundInDelegate = true
            processor(it)
        }
        if (!foundInDelegate) {
            val syntheticProp = session.mentaDynamicMembersStorage.propertiesCacheByName.getValue(name, null)
            processor(syntheticProp.symbol)
        }
    }

    @DelicateScopeAPI
    override fun withReplacedSessionOrNull(newSession: FirSession, newScopeSession: ScopeSession): FirMentaDynamicScope? {
        val newDelegate = delegate.withReplacedSessionOrNull(newSession, newScopeSession) ?: return null
        return FirMentaDynamicScope(newDelegate, newSession, newScopeSession)
    }
}

class FirMentaDynamicMembersStorage(val session: FirSession) : FirSessionComponent {
    private val cachesFactory = session.firCachesFactory

    private val anyNullableTypeRef = buildResolvedTypeRef {
        coneType = session.builtinTypes.nullableAnyType.coneType
    }

    private val anyArrayTypeRef = buildResolvedTypeRef {
        coneType = ConeClassLikeTypeImpl(
            StandardClassIds.Array.toLookupTag(),
            arrayOf(session.builtinTypes.nullableAnyType.coneType),
            isMarkedNullable = false,
        )
    }

    val functionsCacheByName: FirCache<Name, FirNamedFunction, Nothing?> =
        cachesFactory.createCache { name -> buildPseudoFunctionByName(name) }

    val propertiesCacheByName: FirCache<Name, FirProperty, Nothing?> =
        cachesFactory.createCache { name -> buildPseudoPropertyByName(name) }

    private fun buildPseudoFunctionByName(name: Name): FirNamedFunction = buildNamedFunction {
        status = FirResolvedDeclarationStatusImpl(
            Visibilities.Public,
            Modality.FINAL,
            EffectiveVisibility.Public,
        )

        this.name = name
        this.symbol = FirNamedFunctionSymbol(CallableId(MENTA_DYNAMIC_FQ_NAME, this.name))
        isLocal = false

        moduleData = session.moduleData
        origin = FirDeclarationOrigin.MentaDynamicScope
        resolvePhase = FirResolvePhase.BODY_RESOLVE

        returnTypeRef = anyNullableTypeRef

        val parameter = buildValueParameter {
            moduleData = session.moduleData
            containingDeclarationSymbol = this@buildNamedFunction.symbol
            origin = FirDeclarationOrigin.MentaDynamicScope
            resolvePhase = FirResolvePhase.BODY_RESOLVE
            returnTypeRef = anyArrayTypeRef
            this.name = Name.identifier("args")
            this.symbol = FirValueParameterSymbol()
            isCrossinline = false
            isNoinline = false
            isVararg = true
        }

        valueParameters.add(parameter)
    }

    private fun buildPseudoPropertyByName(name: Name): FirProperty = buildProperty {
        this.name = name
        this.symbol = FirRegularPropertySymbol(CallableId(MENTA_DYNAMIC_FQ_NAME, this.name))

        status = FirResolvedDeclarationStatusImpl(
            Visibilities.Public,
            Modality.FINAL,
            EffectiveVisibility.Public,
        )
        isLocal = false

        moduleData = session.moduleData
        origin = FirDeclarationOrigin.MentaDynamicScope
        resolvePhase = FirResolvePhase.BODY_RESOLVE
        returnTypeRef = anyNullableTypeRef
        isVar = true
    }
}

val FirSession.mentaDynamicMembersStorage: FirMentaDynamicMembersStorage by FirSession.sessionComponentAccessor()
