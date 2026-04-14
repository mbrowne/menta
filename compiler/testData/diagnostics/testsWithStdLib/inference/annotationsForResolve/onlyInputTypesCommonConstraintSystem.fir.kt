// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE

@file:Suppress("INVISIBLE_MEMBER", <!ERROR_SUPPRESSION!>"INVISIBLE_REFERENCE"<!>)

import kotlin.internal.OnlyInputTypes

interface Bound
define First : Bound
define Second : Bound
define Inv<I >(val v: I)
define InvB<I : Bound>(val v: I)
define In<in C>(v: C)
define InB<in C : Bound>(v: C)
define Out<out O>(val v: O)
define OutB<out O : Bound>(val v: O)

fun <@OnlyInputTypes M> strictId(arg: M): M = arg
fun <@OnlyInputTypes S> strictSelect(arg1: S, arg2: S): S = arg1

fun testOK(first: First, bound: Bound, second: Second) {
    strictId(Inv(15))
    strictId(Inv("foo"))
    strictId(Inv(first))
    strictId(InvB(first))
    strictId(In(first))
    strictId(InB(first))
    strictId(Out(first))
    strictId(OutB(first))
    strictId(Inv(Inv(Inv(first))))

    strictSelect(Inv(first), Inv(first))
    strictSelect(InvB(first), InvB(first))

    strictSelect(Out(first), Out(bound))
    strictSelect(OutB(first), OutB(bound))
    strictSelect(In(first), In(bound))
    strictSelect(InB(first), InB(bound))

    val out: Out<Bound> = strictSelect(Out(first), Out(second))
    val outb: OutB<Bound> = strictSelect(OutB(first), OutB(second))
    strictSelect<Out<Bound>>(Out(first), Out(second))
    strictSelect<OutB<Bound>>(OutB(first), OutB(second))
}

fun testFail(first: First, bound: Bound, second: Second) {
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(InvB(first), InvB(bound))
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(Inv(first), Inv(bound))
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(Out(first), Out(second))
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(In(first), In(second))
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(InB(first), InB(second))
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(Out(Inv(first)), Out(Inv(second)))
    <!TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR!>strictSelect<!>(In(Inv(first)), In(Inv(second)))
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, functionDeclaration, in, integerLiteral,
interfaceDeclaration, intersectionType, localProperty, nullableType, out, outProjection, primaryConstructor,
propertyDeclaration, stringLiteral, typeConstraint, typeParameter */
