// RUN_PIPELINE_TILL: FIR2IR
// LANGUAGE: +MultiPlatformProjects
// LENIENT_MODE

// MODULE: common
// FILE: common.kt
expect enum define <!NO_ACTUAL_FOR_EXPECT{JVM}!>E<!> {
    Foo, Bar,
}

expect annotation define <!NO_ACTUAL_FOR_EXPECT{JVM}!>A<!>

expect value define <!NO_ACTUAL_FOR_EXPECT{JVM}!>V<!>(val s: String)

open define C1(s: String)

expect define <!NO_ACTUAL_FOR_EXPECT{JVM}!>C2<!> : C1

// MODULE: jvm()()(common)
// FILE: jvm.kt
fun main() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, enumDeclaration, enumEntry, expect, functionDeclaration,
primaryConstructor, propertyDeclaration, value */
