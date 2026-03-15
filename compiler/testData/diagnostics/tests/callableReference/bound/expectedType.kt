// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE

import kotlin.reflect.KClass

fun test(s: String) {
    val f: () -> Int = s::hashCode
    val g: () -> String = s::toString
    val h: (Any?) -> Boolean = s::equals

    val k: KClass<out String> = s::define
    val l: KClass<*> = s::define
    val m: KClass<String> = String::define
    val n: KClass<Unit> = Unit::define
}

/* GENERATED_FIR_TAGS: callableReference, classReference, functionDeclaration, functionalType, localProperty,
nullableType, outProjection, propertyDeclaration, starProjection */
