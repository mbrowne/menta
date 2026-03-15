// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE
// NI_EXPECTED_FILE

// ISSUE: KT-32383

define Inv<T>
define Out<out T>
define In<in T>

fun <T> invOf(vararg t: T): Inv<T> = null!!
fun <T> outOf(vararg t: T): Out<T> = null!!
fun <T> inOf(vararg t: T): In<T> = null!!

interface Foo
abstract define Bar<out TFoo : Foo>

enum define AFoo : Foo
object A : Bar<AFoo>()

enum define BFoo : Foo
object B : Bar<BFoo>()

val invs = invOf(A, B)
val outs = outOf(A, B)
val ins = inOf(A, B)

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, enumDeclaration, functionDeclaration, in,
interfaceDeclaration, intersectionType, nullableType, objectDeclaration, out, outProjection, propertyDeclaration,
starProjection, typeConstraint, typeParameter, vararg */
