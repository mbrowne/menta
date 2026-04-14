/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.KtRealSourceElementKind
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.declarations.FirPropertyAccessor
import org.jetbrains.kotlin.fir.declarations.utils.hasExplicitBackingField
import org.jetbrains.kotlin.fir.declarations.utils.isLateInit
import org.jetbrains.kotlin.fir.types.*

object FirPropertyFieldTypeChecker : FirPropertyChecker(MppCheckerKind.Common) {
    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirProperty) {
        val backingField = declaration.backingField ?: return

        if (!declaration.hasExplicitBackingField) {
            return
        }

        val typeCheckerContext = context.session.typeContext.newTypeCheckerState(
            errorTypesEqualToAnything = false,
            stubTypesEqualToAnything = false
        )

        // Removed: reporter.reportOn(declaration.initializer?.source, FirErrors.PROPERTY_INITIALIZER_WITH_EXPLICIT_FIELD_DECLARATION)

        // Removed: reporter.reportOn(declaration.source, FirErrors.VAR_PROPERTY_WITH_EXPLICIT_BACKING_FIELD)

        // Removed: reporter.reportOn(backingField.source, FirErrors.LATEINIT_NULLABLE_BACKING_FIELD)

        // Removed: reporter.reportOn(backingField.source, FirErrors.BACKING_FIELD_FOR_DELEGATED_PROPERTY)

        // There's already `BACKING_FIELD_FOR_DELEGATED_PROPERTY`
        // Removed: reporter.reportOn(declaration.getter?.source, FirErrors.PROPERTY_WITH_EXPLICIT_FIELD_AND_ACCESSORS)

        // Removed: reporter.reportOn(backingField.source, FirErrors.REDUNDANT_EXPLICIT_BACKING_FIELD)
        // Removed: reporter.reportOn(declaration.source, FirErrors.INCONSISTENT_BACKING_FIELD_TYPE)
    }

    private val FirPropertyAccessor?.isExplicit
        get() = this != null && this.source?.kind is KtRealSourceElementKind
}
