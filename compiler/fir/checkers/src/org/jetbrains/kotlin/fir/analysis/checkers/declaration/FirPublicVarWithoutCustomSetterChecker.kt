/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.KtFakeSourceElementKind
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.descriptors.Visibilities
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.findClosestClassOrObject
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.declarations.getAnnotationByClassId
import org.jetbrains.kotlin.fir.declarations.impl.FirDefaultPropertySetter
import org.jetbrains.kotlin.fir.declarations.utils.isData
import org.jetbrains.kotlin.fir.declarations.utils.isLateInit
import org.jetbrains.kotlin.fir.declarations.utils.isOverride
import org.jetbrains.kotlin.fir.declarations.utils.visibility
import org.jetbrains.kotlin.fir.symbols.impl.FirRegularClassSymbol
import org.jetbrains.kotlin.name.ClassId

/**
 * Forbids public mutable properties (var) without an explicit setter declaration in non-data classes and objects.
 *
 * Allowed:
 * - `public var` in `data define` classes
 * - `public var` with any explicit setter (including `private set` or a setter body)
 * - `public var` that overrides a supertype member
 * - `public lateinit var` (cannot attach a custom setter syntactically)
 * - `@JvmField public var` (exposes the backing field directly — no setter is possible)
 * - `public val` (immutable) anywhere
 * - Non-public `var` (private by default in Menta)
 * - Properties in interfaces (abstract by nature)
 */
object FirPublicVarWithoutCustomSetterChecker : FirPropertyChecker(MppCheckerKind.Common) {
    private val JVM_FIELD_CLASS_ID = ClassId.fromString("kotlin/jvm/JvmField")

    context(context: CheckerContext, reporter: DiagnosticReporter)
    override fun check(declaration: FirProperty) {
        // Only mutable properties
        if (!declaration.isVar) return

        // Skip synthetic/fake source properties, but allow primary constructor properties
        // (which have KtFakeSourceElementKind.PropertyFromParameter and are user-declared)
        val source = declaration.source ?: return
        if (source.kind is KtFakeSourceElementKind && source.kind != KtFakeSourceElementKind.PropertyFromParameter) return

        // Only public properties (members default to private in Menta)
        if (declaration.visibility != Visibilities.Public) return

        // Only class/object members — skip top-level and local properties
        val containingClass = context.findClosestClassOrObject() ?: return

        // Only CLASS and OBJECT kinds — interfaces are excluded (their properties are abstract by nature)
        val classKind = containingClass.classKind
        if (classKind != ClassKind.CLASS && classKind != ClassKind.OBJECT) return

        // Exempt data classes
        if (containingClass is FirRegularClassSymbol && containingClass.isData) return

        // Exempt overrides (the supertype contract is what matters)
        if (declaration.isOverride) return

        // Exempt lateinit properties — Kotlin/Menta syntax doesn't allow a custom setter on a lateinit var
        if (declaration.isLateInit) return

        // Exempt @JvmField properties — they expose the backing field directly and cannot have a custom setter
        if (declaration.backingField?.getAnnotationByClassId(JVM_FIELD_CLASS_ID, context.session) != null) return

        // Allow if there is any explicit setter declaration (e.g., `private set` or a setter with a body).
        // - FirPropertyAccessorImpl: user wrote a setter with a body → allowed
        // - FirDefaultPropertySetter with real source: user wrote `private set` (or similar) without a body → allowed
        // - FirDefaultPropertySetter with fake source: compiler-generated default → NOT allowed
        val setter = declaration.setter
        if (setter != null) {
            if (setter !is FirDefaultPropertySetter) return  // setter with body
            if (setter.source?.kind !is KtFakeSourceElementKind) return  // user-written accessor modifier
        }

        reporter.reportOn(source, FirErrors.PUBLIC_VAR_WITHOUT_CUSTOM_SETTER)
    }
}
