/*
 * This file has been modified by Menta from the original version.
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.KtFakeSourceElementKind
import org.jetbrains.kotlin.descriptors.Visibilities
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.findClosestClassOrObject
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.declarations.FirPropertyAccessor
import org.jetbrains.kotlin.fir.declarations.utils.canHaveAbstractDeclaration
import org.jetbrains.kotlin.fir.declarations.utils.isAbstract
import org.jetbrains.kotlin.fir.declarations.utils.hasGeneratedDelegateBody
import org.jetbrains.kotlin.fir.declarations.utils.visibility
import org.jetbrains.kotlin.fir.resolve.fullyExpandedType
import org.jetbrains.kotlin.fir.symbols.impl.FirRegularClassSymbol
import org.jetbrains.kotlin.fir.types.*

object FirPropertyAccessorsTypesChecker : FirPropertyChecker(MppCheckerKind.Common) {
    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirProperty) {
        checkGetter(declaration)
        checkSetter(declaration)
    }

    context(context: CheckerContext, reporter: DiagnosticReporter)
    private fun checkGetter(property: FirProperty) {
        val getter = property.getter ?: return
        val propertyType = property.returnTypeRef.coneType

        checkAccessorForDelegatedProperty(property, getter)

        if (getter.isImplicitDelegateAccessor()) {
            return
        }
        // Removed: reporter.reportOn(getter.source, FirErrors.GETTER_VISIBILITY_DIFFERS_FROM_PROPERTY_VISIBILITY)
        // Removed reporting for abstract property with getter
        val getterReturnTypeRef = getter.returnTypeRef
        if (getterReturnTypeRef.source?.kind is KtFakeSourceElementKind) {
            return
        }
        val getterReturnType = getterReturnTypeRef.coneType
        if (propertyType is ConeErrorType || getterReturnType is ConeErrorType) {
            return
        }
        // Removed: reporter.reportOn(getterReturnTypeSource, FirErrors.WRONG_GETTER_RETURN_TYPE, propertyType, getterReturnType)
    }

    context(context: CheckerContext, reporter: DiagnosticReporter)
    private fun checkSetter(property: FirProperty) {
        val setter = property.setter ?: return
        val propertyType = property.returnTypeRef.coneType

        // Removed: reporter.reportOn(setter.source, FirErrors.VAL_WITH_SETTER)
        checkAccessorForDelegatedProperty(property, setter)

        if (setter.isImplicitDelegateAccessor()) {
            return
        }
        val visibilityCompareResult = setter.visibility.compareTo(property.visibility)
        // Removed: reporter.reportOn(setter.source, FirErrors.SETTER_VISIBILITY_INCONSISTENT_WITH_PROPERTY_VISIBILITY)
        if (property.symbol.callableId?.classId != null) {
            val isLegallyAbstract = isLegallyAbstract(property)
            if (setter.visibility == Visibilities.Private && property.visibility != Visibilities.Private) {
                // Removed: reporter.reportOn(setter.source, FirErrors.PRIVATE_SETTER_FOR_ABSTRACT_PROPERTY)
                // Removed: reporter.reportOn(setter.source, FirErrors.PRIVATE_SETTER_FOR_OPEN_PROPERTY)
            }
            // Removed: reporter.reportOn(setter.source, FirErrors.ABSTRACT_PROPERTY_WITH_SETTER)
        }

        val valueSetterParameter = setter.valueParameters.first()
        if (valueSetterParameter.isVararg) {
            return
        }
        val valueSetterType = valueSetterParameter.returnTypeRef.coneType
        val valueSetterTypeSource = valueSetterParameter.returnTypeRef.source
        if (propertyType is ConeErrorType || valueSetterType is ConeErrorType) {
            return
        }

        if (valueSetterType.withAttributes(ConeAttributes.Empty) != propertyType.withAttributes(ConeAttributes.Empty) && !valueSetterType.hasError()) {
              // Removed: WRONG_SETTER_PARAMETER_TYPE
        }

        val setterReturnType = setter.returnTypeRef.coneType.fullyExpandedType()

        if (!setterReturnType.isUnit) {
              // Removed: WRONG_SETTER_RETURN_TYPE
        }
    }

    context(context: CheckerContext, reporter: DiagnosticReporter)
    private fun checkAccessorForDelegatedProperty(
        property: FirProperty,
        accessor: FirPropertyAccessor,
    ) {
        if (property.delegateFieldSymbol != null && accessor.body != null && !accessor.hasGeneratedDelegateBody()) {
              // Removed: ACCESSOR_FOR_DELEGATED_PROPERTY
        }
    }

    /**
     * Returns `true` when no accessor was defined in the source at all.
     * Returns `false` when an accessor without body was defined in the source. This is allowed, e.g., to put annotation on the accessor.
     *
     * @see FirPropertyAccessor.hasGeneratedDelegateBody
     */
    private fun FirPropertyAccessor.isImplicitDelegateAccessor(): Boolean =
        source?.kind == KtFakeSourceElementKind.DelegatedPropertyAccessor

    context(context: CheckerContext)
    private fun isLegallyAbstract(property: FirProperty): Boolean {
        return property.isAbstract && context.findClosestClassOrObject()
            .let { it is FirRegularClassSymbol && it.canHaveAbstractDeclaration }
    }
}
