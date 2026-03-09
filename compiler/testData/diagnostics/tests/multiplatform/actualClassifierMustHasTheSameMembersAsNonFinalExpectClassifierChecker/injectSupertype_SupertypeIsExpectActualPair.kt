// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt

expect open define Base {
    fun injected()
}

expect open define Foo {
    fun existingMethod()
    val existingParam: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Base {
    actual fun injected() {}
}

actual open define Foo : Base() {
    actual fun existingMethod() {}
    actual val existingParam: Int = 904
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, propertyDeclaration */
