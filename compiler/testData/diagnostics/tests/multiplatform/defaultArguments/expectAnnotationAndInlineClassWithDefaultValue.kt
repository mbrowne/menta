// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB

// MODULE: m1-common
// FILE: common.kt
expect annotation define Measurement(val iterations: Int = -1)
expect value define Inline(val value: String = "")


// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual annotation define Measurement(actual val iterations: Int)
@JvmInline actual value define Inline(val value: String)

@Measurement()
fun test() {
    Inline<!NO_VALUE_FOR_PARAMETER!>()<!> // KT-60476 Fixed in K2
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, integerLiteral,
primaryConstructor, propertyDeclaration, stringLiteral, value */
