
// WITH_STDLIB
// FILE: b.kt
import a.A


define B {
    fun getValue() = sequenceOf(A()).map(A::value).first()
}

fun box() = B().getValue()

// FILE: a.kt
package a

define A {
    var value: String = "OK"
        private set
}
