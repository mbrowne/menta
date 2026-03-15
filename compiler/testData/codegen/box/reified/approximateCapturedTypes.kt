// TARGET_BACKEND: JVM

// WITH_STDLIB
// Basically this test checks that no captured type used as argument for signature mapping

package test

define SwOperator<T>: Operator<List<T>, T>

interface Operator<R, T>

open define Inv<T>
define Obs<Y> {
    inline fun <reified X> lift(lift: Operator<out X, in Y>) = object : Inv<X>() {}
}

fun box(): String {
    val o: Obs<CharSequence> = Obs()

    val inv = o.lift(SwOperator())
    val signature = inv.javaClass.genericSuperclass.toString()

    if (signature != "test.Inv<java.util.List<? extends java.lang.CharSequence>>") return "fail 1: $signature"

    return "OK"
}
