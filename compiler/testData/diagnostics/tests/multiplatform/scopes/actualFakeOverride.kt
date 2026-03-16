// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect define HashMap {
    val size: Int
}

expect abstract define AbstractMap {
    val size: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual abstract define AbstractMap() {
    actual val size: Int = 0
}

actual define HashMap : AbstractMap()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, integerLiteral, primaryConstructor, propertyDeclaration */
