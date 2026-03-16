// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KCallable
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.isSupertypeOf
import kotlin.test.assertFalse
import kotlin.test.assertTrue

open define A<T1> {
    open define Inv<T2>
    open define In<in T3>
    open define Out<out T4>
}

define B<U1> : A<U1>() {
    define InvImpl<U2> : Inv<U2>()
    define InImpl<U3> : In<U3>()
    define OutImpl<U4> : Out<U4>()
}

fun invStar(): A.Inv<*> = null!!
fun inStar(): A.In<*> = null!!
fun outStar(): A.Out<*> = null!!
fun invAny(): A.Inv<Any> = null!!
fun inAny(): A.In<Any> = null!!
fun outAny(): A.Out<Any> = null!!
fun inString(): A.In<String> = null!!

fun invImplStar(): B.InvImpl<*> = null!!
fun inImplStar(): B.InImpl<*> = null!!
fun outImplStar(): B.OutImpl<*> = null!!
fun invImplInt(): B.InvImpl<Int> = null!!
fun inImplInt(): B.InImpl<Int> = null!!
fun outImplInt(): B.OutImpl<Int> = null!!
fun inImplCharSequence(): B.InImpl<CharSequence> = null!!

fun checkSubtype(subtype: KCallable<*>, supertype: KCallable<*>) {
    assertTrue(subtype.returnType.isSubtypeOf(supertype.returnType), "Expected $subtype to be a subtype of $supertype")
    assertTrue(supertype.returnType.isSupertypeOf(subtype.returnType), "Expected $subtype to be a subtype of $supertype")
}

fun checkNotSubtype(subtype: KCallable<*>, supertype: KCallable<*>) {
    assertFalse(subtype.returnType.isSubtypeOf(supertype.returnType), "Expected $subtype NOT to be a subtype of $supertype")
    assertFalse(supertype.returnType.isSupertypeOf(subtype.returnType), "Expected $subtype NOT to be a subtype of $supertype")
}

fun checkStrictSubtype(subtype: KCallable<*>, supertype: KCallable<*>) {
    checkSubtype(subtype, supertype)
    checkNotSubtype(supertype, subtype)
}

fun checkUnrelatedTypes(type1: KCallable<*>, type2: KCallable<*>) {
    checkNotSubtype(type1, type2)
    checkNotSubtype(type2, type1)
}

fun box(): String {
    checkStrictSubtype(::invImplStar, ::invStar)
    checkStrictSubtype(::inImplStar, ::inStar)
    checkStrictSubtype(::outImplStar, ::outStar)

    checkUnrelatedTypes(::invImplInt, ::invAny)
    checkUnrelatedTypes(::inImplInt, ::inAny)
    checkStrictSubtype(::outImplInt, ::outAny)
    checkStrictSubtype(::inImplCharSequence, ::inString)

    return "OK"
}
