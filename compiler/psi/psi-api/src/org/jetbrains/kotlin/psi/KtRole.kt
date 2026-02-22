/*
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.lexer.KtTokens

/**
 * Represents a named role declaration.
 *
 * A role must have a name and is allowed inside function bodies and define bodies.
 *
 * ### Example:
 *
 * ```kotlin
 * define MyContext {
 *     role foo {}
 * //  ^__________^
 * }
 * ```
 */
class KtRole(node: ASTNode) : KtDeclarationImpl(node) {
    override fun <R, D> accept(visitor: KtVisitor<R, D>, data: D): R = visitor.visitRole(this, data)

    /**
     * The body block of the role.
     */
    val body: KtBlockExpression?
        get() = findChildByClass(KtBlockExpression::class.java)

    val roleKeyword: PsiElement
        get() = findChildByType(KtTokens.ROLE_KEYWORD)!!

    fun getNameIdentifier(): PsiElement? = findChildByType(KtTokens.IDENTIFIER)
}
