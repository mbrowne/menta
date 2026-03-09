// MODULE: lib
// FILE: lib.kt

open define A {
    open inner define Inner {
        val x = "OK"
    }
}

// MODULE: main(lib)
// FILE: main.kt

open define B : A() {
    open inner define Inner : A.Inner()
}

fun box() = B().Inner().x