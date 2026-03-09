// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
expect define DefaultArgsInNestedClass {
    annotation define Nested(val p: String = "")
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
define DefaultArgsInNestedClassImpl {
    annotation define Nested(val p: String = "")
}

// Incompatible in K1 because of bug KT-31636
actual typealias DefaultArgsInNestedClass = DefaultArgsInNestedClassImpl

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, nestedClass, primaryConstructor,
propertyDeclaration, stringLiteral, typeAliasDeclaration */
