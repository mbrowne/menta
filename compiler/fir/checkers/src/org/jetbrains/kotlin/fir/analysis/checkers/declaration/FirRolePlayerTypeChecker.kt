/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.KtFakeSourceElementKind
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.declaredMemberScope
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.resolve.toRegularClassSymbol
import org.jetbrains.kotlin.fir.scopes.processAllFunctions
import org.jetbrains.kotlin.fir.scopes.processAllProperties
import org.jetbrains.kotlin.fir.symbols.impl.FirPropertySymbol
import org.jetbrains.kotlin.fir.types.ConeKotlinType
import org.jetbrains.kotlin.fir.types.resolvedType
import org.jetbrains.kotlin.name.Name

/**
 * Checks that role players with `requires {}` (empty contract) have types with no declared members.
 *
 * This runs on synthetic type-check properties generated at raw FIR time for empty-requires roles.
 * The property name matches `<role$NAME$emptyRequiresCheck>` and has a RolePlayerTypeCheck fake source.
 */
object FirRolePlayerTypeChecker : FirPropertyChecker(MppCheckerKind.Common) {
    private val ANY_METHOD_NAMES = setOf(
        Name.identifier("equals"),
        Name.identifier("hashCode"),
        Name.identifier("toString"),
    )

    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirProperty) {
        val source = declaration.source ?: return
        if (source.kind != KtFakeSourceElementKind.RolePlayerTypeCheck) return

        // Only check empty-requires properties (named <role$NAME$emptyRequiresCheck>)
        val nameStr = declaration.name.asString()
        if (!nameStr.contains("\$emptyRequiresCheck>")) return

        val initializer = declaration.initializer ?: return
        val playerType = initializer.resolvedType

        if (typeHasDeclaredMembers(playerType)) {
            reporter.reportOn(source, FirErrors.EMPTY_REQUIRES_ROLE_PLAYER_HAS_MEMBERS, playerType)
        }
    }

    context(context: CheckerContext)
    private fun typeHasDeclaredMembers(type: ConeKotlinType): Boolean {
        val classSymbol = type.toRegularClassSymbol(context.session) ?: return false
        val scope = classSymbol.declaredMemberScope()

        var hasNonTrivialFunction = false
        scope.processAllFunctions { functionSymbol ->
            if (functionSymbol.name !in ANY_METHOD_NAMES) {
                hasNonTrivialFunction = true
            }
        }
        if (hasNonTrivialFunction) return true

        var hasNonSyntheticProperty = false
        scope.processAllProperties { propertySymbol ->
            if (propertySymbol is FirPropertySymbol && propertySymbol.origin == FirDeclarationOrigin.Source) {
                hasNonSyntheticProperty = true
            }
        }
        return hasNonSyntheticProperty
    }
}
