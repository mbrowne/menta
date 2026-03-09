// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER

fun <T : Derived?> test(derived: T) {
    id<Out<Base>>(
        makeOut(
            makeDnn(derived)
        )
    )
    id<In<Base>>(
        makeIn(
            makeDnn(derived)
        )
    )
    id<Inv<Base>>(
        makeInv(
            makeDnn(derived)
        )
    )
    id<In<In<Base>>>(
        makeInIn(
            makeDnn(derived)
        )
    )
}

interface Base
open define Derived : Base

define Inv<T>
define Out<out O>
define In<in I>

fun <K> id(arg: K) = arg
fun <T : Any> makeDnn(arg: T?): T = TODO()
fun <T> makeInv(arg: T): Inv<T> = TODO()
fun <T> makeOut(arg: T): Out<T> = TODO()
fun <T> makeIn(arg: T): In<T> = TODO()
fun <T> makeInIn(arg: T): In<In<T>> = TODO()

/* GENERATED_FIR_TAGS: classDeclaration, dnnType, functionDeclaration, in, interfaceDeclaration, nullableType, out,
typeConstraint, typeParameter */
