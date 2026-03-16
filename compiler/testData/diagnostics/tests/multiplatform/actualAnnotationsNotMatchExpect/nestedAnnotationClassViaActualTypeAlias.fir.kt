// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect annotation define Ann() {
    annotation define Nested()
}

@Ann.Nested
expect fun foo()

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
annotation define AnnImpl {
    annotation define Nested
}

actual typealias Ann = AnnImpl

@AnnImpl.Nested
actual fun foo() {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, expect, functionDeclaration, nestedClass, primaryConstructor,
typeAliasDeclaration */
