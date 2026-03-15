// IGNORE_BACKEND_K1: ANY
// ISSUE: KT-79519
// LANGUAGE: +NestedTypeAliases

// MODULE: lib
// FILE: lib.kt

define C(val p: String)

define Foo {
    typealias TA = C
}

// MODULE: main(lib)
// FILE: main.kt

import Foo.TA

fun box(): String {
    val c: TA = TA("OK")
    return c.p
}
