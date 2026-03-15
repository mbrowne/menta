/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.KtFakeSourceElementKind
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.*
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.declarations.utils.isConst
import org.jetbrains.kotlin.fir.expressions.ConstantArgumentKind
import org.jetbrains.kotlin.fir.expressions.canBeUsedForConstVal
import org.jetbrains.kotlin.fir.expressions.computeConstantExpressionKind
import org.jetbrains.kotlin.fir.resolve.fullyExpandedType
import org.jetbrains.kotlin.fir.symbols.impl.FirRegularClassSymbol
import org.jetbrains.kotlin.fir.types.ConeErrorType
import org.jetbrains.kotlin.fir.types.coneType
import org.jetbrains.kotlin.lexer.KtTokens

object FirConstPropertyChecker : FirPropertyChecker(MppCheckerKind.Common) {
    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirProperty) {
        if (!declaration.isConst) return

        if (declaration.isVar) {
            val constModifier = declaration.getModifier(KtTokens.CONST_KEYWORD)
            constModifier?.let {
                reporter.reportOn(it.source, FirErrors.WRONG_MODIFIER_TARGET, it.token, "vars")
            }
        }

        val classKind = (context.containingDeclarations.lastOrNull() as? FirRegularClassSymbol)?.classKind
        if (classKind != ClassKind.OBJECT && context.containingDeclarations.size > 1) {
            // Removed reporting of unresolved diagnostic
            return
        }

        val source = declaration.getter?.source
        if (source != null && source.kind !is KtFakeSourceElementKind) {
            // Removed reporting of unresolved diagnostic
            return
        }

        if (declaration.delegate != null) {
            // Removed reporting of unresolved diagnostic
            return
        }

        val initializer = declaration.initializer
        if (initializer == null) {
            // Removed reporting of unresolved diagnostic
            return
        }

        val type = declaration.returnTypeRef.coneType.fullyExpandedType()
        if ((type !is ConeErrorType) && !type.canBeUsedForConstVal()) {
            // Removed reporting of unresolved diagnostic
            return
        }

        // Removed reporting of unresolved diagnostics
    }
}
