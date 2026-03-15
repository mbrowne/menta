// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -TYPE_MISMATCH
// MODULE: common
expect annotation define Typealiased()

annotation define Ann(val p: Typealiased)

@Ann(Typealiased())
expect fun test()

// MODULE: main()()(common)
annotation define TypealiasedImpl

actual typealias Typealiased = TypealiasedImpl

@Ann(Typealiased())
actual fun test() {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, expect, functionDeclaration, primaryConstructor,
propertyDeclaration, typeAliasDeclaration */
