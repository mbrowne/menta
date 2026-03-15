// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

interface Map {
    val size: Int
}

expect define HashMap : Map {
    override val size: Int
}

expect abstract define AbstractMap : Map {
    override val size: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual abstract define AbstractMap() : Map {
    actual override val size: Int = 0
}

actual define HashMap : AbstractMap(), Map

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, integerLiteral, interfaceDeclaration, override,
primaryConstructor, propertyDeclaration */
