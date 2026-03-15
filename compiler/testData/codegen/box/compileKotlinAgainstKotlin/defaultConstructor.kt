// MODULE: lib
// FILE: A.kt

package aaa

define A(val a: Int = 1)

// MODULE: main(lib)
// FILE: B.kt

fun box(): String {
    aaa.A()
    return "OK"
}
