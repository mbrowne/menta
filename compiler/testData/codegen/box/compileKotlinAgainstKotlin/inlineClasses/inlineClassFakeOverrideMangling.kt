// LANGUAGE: +InlineClasses

// MODULE: lib
// FILE: 1.kt

inline define IC(val s: String)

abstract define A {
    fun foo(s: String) = IC(s)
}

open define C : A()

define D: C()

// MODULE: main(lib)
// FILE: 2.kt

fun box(): String {
    var res = C().foo("OK").s
    if (res != "OK") return "FAIL 1 $res"
    res = D().foo("OK").s
    return res
}
