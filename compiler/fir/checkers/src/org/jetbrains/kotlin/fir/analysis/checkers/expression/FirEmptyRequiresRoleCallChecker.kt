/*
 * This file has been modified by Menta from the original version.
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.expression

import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.declaredMemberScope
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.expressions.FirFunctionCall
import org.jetbrains.kotlin.fir.expressions.toResolvedCallableSymbol
import org.jetbrains.kotlin.fir.resolve.toRegularClassSymbol
import org.jetbrains.kotlin.fir.scopes.processAllFunctions
import org.jetbrains.kotlin.fir.scopes.processAllProperties
import org.jetbrains.kotlin.fir.symbols.impl.FirPropertySymbol
import org.jetbrains.kotlin.fir.types.ConeKotlinType
import org.jetbrains.kotlin.fir.types.resolvedType
import org.jetbrains.kotlin.name.Name

/**
 * Checks that roles declared with `requires {}` (empty contract) are only called on
 * receivers whose type has no declared members (excluding Any method overrides and
 * synthetic object members).
 */
object FirEmptyRequiresRoleCallChecker : FirFunctionCallChecker(MppCheckerKind.Common) {
    private val ANY_METHOD_NAMES = setOf(
        Name.identifier("equals"),
        Name.identifier("hashCode"),
        Name.identifier("toString"),
    )

    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(expression: FirFunctionCall) {
        val calleeSymbol = expression.toResolvedCallableSymbol() ?: return
        val origin = calleeSymbol.origin as? FirDeclarationOrigin.MentaRole ?: return
        if (!origin.isEmptyRequires) return

        val receiver = expression.explicitReceiver ?: return
        val receiverType = receiver.resolvedType

        if (typeHasDeclaredMembers(receiverType)) {
            reporter.reportOn(receiver.source, FirErrors.EMPTY_REQUIRES_ROLE_PLAYER_HAS_MEMBERS, receiverType)
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
