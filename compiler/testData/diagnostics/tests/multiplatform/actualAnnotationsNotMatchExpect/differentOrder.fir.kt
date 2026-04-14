// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
annotation define Ann1
annotation define Ann2

@Ann1
@Ann2
expect define AnnotationOrder

annotation define Ann3(vararg val numbers: Int)

@Ann3(1, 2)
expect define ValuesOrderInsideAnnotationArgument

annotation define Ann4(val arg1: String, val arg2: String)

@Ann4(arg1 = "1", arg2 = "2")
expect fun differentArgumentsOrder()

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

@Ann2
@Ann1
actual define AnnotationOrder

@Ann3(2, 1)
<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> define ValuesOrderInsideAnnotationArgument

@Ann4(arg2 = "2", arg1 = "1")
actual fun differentArgumentsOrder() {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, integerLiteral,
primaryConstructor, propertyDeclaration, stringLiteral, vararg */
