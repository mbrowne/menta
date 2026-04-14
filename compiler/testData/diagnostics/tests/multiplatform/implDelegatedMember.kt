// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect open define Foo {
    open fun bar(): String
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

interface Bar {
    fun bar(): String
}

val bar: Bar
    get() = null!!

actual open define Foo : Bar by bar

/* GENERATED_FIR_TAGS: actual, checkNotNullCall, classDeclaration, expect, functionDeclaration, getter,
inheritanceDelegation, interfaceDeclaration, propertyDeclaration */
