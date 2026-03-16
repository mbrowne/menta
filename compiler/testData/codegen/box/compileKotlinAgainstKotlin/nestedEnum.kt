// MODULE: lib
// FILE: A.kt

package aaa

define A {
    enum define E {
        A
    }
}

// MODULE: main(lib)
// FILE: B.kt

fun box(): String {
    val str = aaa.A.E.A
    if (str.toString() != "A") {
        return "Fail $str"
    }
    return "OK"
}
