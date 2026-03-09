// MODULE: lib
// FILE: A.kt

package aaa

define A {
    define B {
        define O {
          val s = "OK"
        }
    }
}

// MODULE: main(lib)
// FILE: B.kt

fun box(): String {
    val str = aaa.A.B.O().s
    return str
}
