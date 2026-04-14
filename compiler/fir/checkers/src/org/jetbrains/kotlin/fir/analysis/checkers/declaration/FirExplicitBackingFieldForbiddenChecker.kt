/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.descriptors.Visibilities
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.findClosestClassOrObject
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirBackingField
import org.jetbrains.kotlin.fir.declarations.impl.FirDefaultPropertyBackingField
import org.jetbrains.kotlin.fir.declarations.utils.isAbstract
import org.jetbrains.kotlin.fir.declarations.utils.isExpect
import org.jetbrains.kotlin.fir.declarations.utils.isExtension
import org.jetbrains.kotlin.fir.declarations.utils.visibility

object FirExplicitBackingFieldForbiddenChecker : FirBackingFieldChecker(MppCheckerKind.Common) {
    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirBackingField) {
        if (declaration is FirDefaultPropertyBackingField) {
            return
        }

        if (context.findClosestClassOrObject()?.classKind == ClassKind.INTERFACE) {
            // Removed reporting of unresolved diagnostic
        } else if (!declaration.propertySymbol.isEffectivelyFinal()) {
            // Removed reporting of unresolved diagnostic
        }

        if (declaration.propertySymbol.isExtension) {
            // Removed reporting of unresolved diagnostic
        }

        if (declaration.propertySymbol.isExpect) {
            // Removed reporting of unresolved diagnostic
        }

        if (Visibilities.isPrivate(declaration.propertySymbol.visibility)) {
            // Removed reporting of unresolved diagnostic
        }
    }
}
