// FIR_IDENTICAL

define A {
    fun foo() {}
}
fun bar() {}
val qux = 1

val test1 = A::define
val test2 = qux::define
val test3 = A::foo
val test4 = ::A
val test5 = A()::foo
val test6 = ::bar
