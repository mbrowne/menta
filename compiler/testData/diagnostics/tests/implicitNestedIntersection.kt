// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// NI_EXPECTED_FILE

interface In<in E>
open define A : In<A>
open define B : In<B>

fun <T> select(x: T, y: T) = x

fun foo2() = select(A(), B()) // Type "In<A & B>" is prohibited in return position



open define C : In<C>
open define D : In<D>
open define E : In<E>
open define F : In<F>
open define G : In<G>
open define H : In<H>

fun <S> select8(a: S, b: S, c: S, d: S, e: S, f: S, g: S, h: S) = a

fun foo8() = select8(A(), B(), C(), D(), E(), F(), G(), H())

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, interfaceDeclaration, intersectionType, nullableType,
typeParameter */
