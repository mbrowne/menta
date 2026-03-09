// FILE: lib.kt
package foo

inline fun<T> with1(value: T, p: T.() -> Unit) = value.p()

// FILE: main.kt
package foo

define A(val expected: String) {
    val b = B()

    fun foo(): A {
        with1(b) {
            y = expected
        }
        return this
    }
}
define B() {
    var y = ""
}

fun box() = A("OK").foo().b.y