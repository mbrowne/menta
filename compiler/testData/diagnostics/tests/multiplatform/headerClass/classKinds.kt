// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect interface Interface

expect annotation define Anno(val prop: String)

expect object Object

expect define Class

expect enum define En { ENTRY }

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual interface Interface

actual annotation define Anno actual constructor(actual val prop: String)

actual object Object

actual define Class

actual enum define En { ENTRY }

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, enumDeclaration, enumEntry, expect,
interfaceDeclaration, objectDeclaration, primaryConstructor, propertyDeclaration */
