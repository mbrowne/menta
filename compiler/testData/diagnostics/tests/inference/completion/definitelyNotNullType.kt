// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER

fun <T : Derived?> test(derived: T) {
    <!DEBUG_INFO_EXPRESSION_TYPE("Out<Base>")!>id<Out<Base>>(
        <!DEBUG_INFO_EXPRESSION_TYPE("Out<T & Any>")!>makeOut(
            <!DEBUG_INFO_EXPRESSION_TYPE("T & Any")!>makeDnn(derived)<!>
        )<!>
    )<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("In<Base>")!>id<In<Base>>(
        <!DEBUG_INFO_EXPRESSION_TYPE("In<Base>")!>makeIn(
            <!DEBUG_INFO_EXPRESSION_TYPE("T & Any")!>makeDnn(derived)<!>
        )<!>
    )<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("Inv<Base>")!>id<Inv<Base>>(
        <!DEBUG_INFO_EXPRESSION_TYPE("Inv<Base>")!>makeInv(
            <!DEBUG_INFO_EXPRESSION_TYPE("T & Any")!>makeDnn(derived)<!>
        )<!>
    )<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("In<In<Base>>")!>id<In<In<Base>>>(
        <!DEBUG_INFO_EXPRESSION_TYPE("In<In<T & Any>>")!>makeInIn(
            <!DEBUG_INFO_EXPRESSION_TYPE("T & Any")!>makeDnn(derived)<!>
        )<!>
    )<!>
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
