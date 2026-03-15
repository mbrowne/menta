// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define In<in I>(arg: I)
define Out<out O>(val prop: O)
define Inv<T>(val prop: T)

interface Upper
define Lower : Upper

fun <K> id(arg: K): K = arg

fun test(lower: Lower) {
    id<Inv<Upper>>(Inv(lower))
    id<In<Upper>>(In(lower))
    id<Out<Upper>>(Out(lower))
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, interfaceDeclaration, nullableType, out,
primaryConstructor, propertyDeclaration, typeParameter */
