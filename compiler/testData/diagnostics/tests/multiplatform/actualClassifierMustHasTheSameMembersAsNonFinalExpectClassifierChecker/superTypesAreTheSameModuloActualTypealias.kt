// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect open define Supertype()

expect open define Foo : Supertype {
    fun existingMethod()
    val existingParam: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual typealias Supertype = SupertypeImpl

open define SupertypeImpl()

actual open define Foo : SupertypeImpl() {
    actual fun existingMethod() {}
    actual val existingParam: Int = 904
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, primaryConstructor,
propertyDeclaration, typeAliasDeclaration */
