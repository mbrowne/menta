// RUN_PIPELINE_TILL: FIR2IR
// LANGUAGE: +MultiPlatformProjects
// LENIENT_MODE

// MODULE: common
// FILE: common.kt
expect enum define E {
    Foo, Bar,
}

expect annotation define A

expect value define V(val s: String)

open define C1(s: String)

expect define C2 : C1

// MODULE: jvm()()(common)
// FILE: jvm.kt
fun main() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, enumDeclaration, enumEntry, expect, functionDeclaration,
primaryConstructor, propertyDeclaration, value */
