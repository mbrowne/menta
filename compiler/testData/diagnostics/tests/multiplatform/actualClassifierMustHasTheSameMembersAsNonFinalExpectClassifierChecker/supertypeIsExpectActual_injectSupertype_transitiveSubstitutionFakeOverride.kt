// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt

expect open define Base<T> {
    fun injected(param: T)
}

expect open define Foo {
    fun existingMethod()
    val existingParam: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Base<T> {
    actual fun injected(param: T) {}
}

open define Transitive : Base<String>()

actual open define Foo : Transitive() {
    actual fun existingMethod() {}
    actual val existingParam: Int = 904
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, nullableType,
propertyDeclaration, typeParameter */
