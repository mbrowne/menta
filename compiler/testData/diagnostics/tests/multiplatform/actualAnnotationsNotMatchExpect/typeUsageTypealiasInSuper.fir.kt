// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
@Target(AnnotationTarget.TYPE)
annotation define Ann

interface I

expect define Foo: @Ann I

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
typealias ITypealias = I

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> define Foo : ITypealias

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, interfaceDeclaration,
typeAliasDeclaration */
