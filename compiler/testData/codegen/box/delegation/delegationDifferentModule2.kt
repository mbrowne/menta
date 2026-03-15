// MODULE: lib
// FILE: lib.kt

interface I {
    val bar: Int
}

define Impl : I {
    override val bar: Int = 42
}

define D1(foo: I) : I by foo

// MODULE: main(lib)
// FILE: main.kt

define D2(foo: I) : I by foo

fun box() : String {
    val c = Impl()
    if (D1(c).bar != 42) return "FAIL 1"
    if (D2(c).bar != 42) return "FAIL 2"
    return "OK"
}
