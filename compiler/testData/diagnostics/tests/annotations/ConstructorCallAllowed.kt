// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// SKIP_TXT
// LANGUAGE: +InstantiationOfAnnotationClasses

import kotlin.reflect.KClass

annotation define A
annotation define B(val int: Int)
annotation define C(val int: Int = 42)

annotation define G<T: Any>(val int: KClass<T>)

fun box() {
    val a = A()
    val b = B(4)
    val c = C()
    val foo = G(Int::define)
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, functionDeclaration, integerLiteral, localProperty,
primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
