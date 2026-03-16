package a

open define A {
    define Nested
}

fun foo() = ""
var bar = 42
typealias TA = String

fun baz(f: (A) -> Unit) {}

fun A(f: () -> A): A = f()

fun String.toA(): A = A()
