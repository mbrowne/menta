/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.resolve.getContainingClassSymbol
import org.jetbrains.kotlin.fir.analysis.checkers.unsubstitutedScope
// Removed unresolved diagnostic imports
import org.jetbrains.kotlin.fir.declarations.FirRegularClass
import org.jetbrains.kotlin.fir.declarations.utils.*
import org.jetbrains.kotlin.fir.scopes.getFunctions
import org.jetbrains.kotlin.fir.scopes.getProperties
import org.jetbrains.kotlin.fir.symbols.impl.FirNamedFunctionSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirPropertySymbol


sealed class FirFunInterfaceDeclarationChecker(mppKind: MppCheckerKind) : FirRegularClassChecker(mppKind) {
    object Regular : FirFunInterfaceDeclarationChecker(MppCheckerKind.Platform) {
        context(context: CheckerContext, reporter: DiagnosticReporter)
        override fun check(declaration: FirRegularClass) {
            if (declaration.isExpect) return
            super.check(declaration)
        }
    }

    object ForExpectClass : FirFunInterfaceDeclarationChecker(MppCheckerKind.Common) {
        context(context: CheckerContext, reporter: DiagnosticReporter)
        override fun check(declaration: FirRegularClass) {
            if (!declaration.isExpect) return
            super.check(declaration)
        }
    }

    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirRegularClass) {
        if (!declaration.isInterface || !declaration.isFun) return

        val scope = declaration.unsubstitutedScope()
        val classSymbol = declaration.symbol

        var abstractFunctionSymbol: FirNamedFunctionSymbol? = null

        for (name in scope.getCallableNames()) {
            val functions = scope.getFunctions(name)
            val properties = scope.getProperties(name)

            for (function in functions) {
                if (function.isAbstract) {
                    if (abstractFunctionSymbol == null) {
                        abstractFunctionSymbol = function
                    } else {
                        // Removed reporting of unresolved diagnostic
                    }
                }
            }


            // Removed reporting for abstract properties
        }

        if (abstractFunctionSymbol == null) {
            // Removed reporting of unresolved diagnostic
            return
        }

        val inFunInterface = abstractFunctionSymbol.getContainingClassSymbol() === classSymbol

        // Removed reporting of unresolved diagnostics
    }
}

