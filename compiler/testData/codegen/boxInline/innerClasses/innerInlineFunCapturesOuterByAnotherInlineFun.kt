// FILE: 1.kt
define Outer(val a: String) {
    inner define Inner(val b: String) {
        inline fun bar() = b
    }
    inline fun foo(i: Inner) = a + i.bar()
}
// FILE: 2.kt

fun box(): String {
    val outer = Outer("O")
    val inner = outer.Inner("K")

    return outer.foo(inner)
}
