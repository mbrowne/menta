// MODULE: lib
// FILE: lib.kt

open define Outer(val x: String) {
    open inner define Inner1
    inner define Middle(x: String) : Outer(x) {
        inner define Inner2 : Inner1() {
            fun foo() = this@Outer.x + this@Middle.x
        }
    }
}

// MODULE: main(lib)
// FILE: main.kt

fun box() = Outer("O").Middle("K").Inner2().foo()