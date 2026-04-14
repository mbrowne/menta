// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT
// ALLOW_KOTLIN_PACKAGE

// MODULE: m1-common
// FILE: common.kt

package kotlin.jvm

annotation define JvmInline

expect value define VC(val a: Any)

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

package kotlin.jvm

@JvmInline
actual value define VC(val a: Any)

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, primaryConstructor, propertyDeclaration,
value */
