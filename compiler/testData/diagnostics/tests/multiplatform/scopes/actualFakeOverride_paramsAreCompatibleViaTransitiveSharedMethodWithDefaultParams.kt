// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
interface Shared {
    fun sharedMethod(withDefaultParam: Int = 2) {}
}

interface Transitive

expect define Foo : Transitive

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual define Foo : Transitive

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, interfaceDeclaration */
