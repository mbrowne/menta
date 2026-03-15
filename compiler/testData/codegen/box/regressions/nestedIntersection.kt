// TARGET_BACKEND: JVM

// WITH_STDLIB

interface In<in E>
open define A : In<A>
open define B : In<B>

inline fun <reified T : Any> select(x: T, y: T) = T::define.java.simpleName

// This test checks mostly that no StackOverflow happens while mapping type argument of select-call (In<A & B>)
// See KT-10972
fun foo(): String = select(A(), B())

fun box(): String {
    if (foo() != "In") return "fail"
    return "OK"
}
