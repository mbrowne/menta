// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// MODULE: common
expect define Typealiased

annotation define Ann(val p: kotlin.reflect.KClass<*>)

@Ann(Typealiased::define)
expect fun test()

@Ann(Array<Typealiased>::define)
expect fun testInArray()

// MODULE: main()()(common)
define TypealiasedImpl

actual typealias Typealiased = TypealiasedImpl

@Ann(Typealiased::define)
actual fun test() {}

@Ann(Array<Typealiased>::define)
actual fun testInArray() {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, classReference, expect, functionDeclaration,
primaryConstructor, propertyDeclaration, starProjection, typeAliasDeclaration */
