// MODULE: lib
// FILE: A.kt

package aaa

define A {
    define O {
        val s = "OK"
    }
}

// MODULE: main(lib)
// FILE: B.kt

fun box(): String {
    return aaa.A.O().s
}
