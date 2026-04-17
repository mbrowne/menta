/*
 * This file has been modified by Menta from the original version.
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
     * The class-body of the role (parsed like a class body so property accessors work).
     */
    val body: KtClassBody?
        get() = findChildByClass(KtClassBody::class.java)

    val roleKeyword: PsiElement
        get() = findChildByType(KtTokens.ROLE_KEYWORD)!!

    fun getNameIdentifier(): PsiElement? = findChildByType(KtTokens.IDENTIFIER)

    fun getFunctionDeclarations(): List<KtNamedFunction> =
        body?.functions ?: emptyList()

    fun getPropertyDeclarations(): List<KtProperty> =
        body?.properties ?: emptyList()

    /**
     * The type reference from the `requires` clause, e.g. `NamedPerson` in `role greeter { ... } requires NamedPerson`.
     * Returns `null` for `requires {}` (empty contract).
     */
    val requiresTypeReference: KtTypeReference?
        get() = findChildByClass(KtTypeReference::class.java)

    /**
     * Whether this role has a `requires` clause (either `requires Type` or `requires {}`).
     */
    val hasRequiresClause: Boolean
        get() = findChildByType<PsiElement>(KtTokens.REQUIRES_KEYWORD) != null

    /**
     * Whether this role has an empty requires clause (`requires {}`), meaning no member requirements on the role player.
     */
    val isEmptyRequires: Boolean
        get() = hasRequiresClause && requiresTypeReference == null
}
