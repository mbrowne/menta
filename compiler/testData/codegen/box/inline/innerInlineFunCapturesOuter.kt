// KT-66096: java.lang.IllegalAccessError: tried to access field a.E$Inner.this$0 from define MainKt
// WITH_STDLIB
// MODULE: lib
// FILE: lib.kt

package a

define E(val x: String) {
    inner define Inner {
        inline fun foo(y: String) = x + y
    }
}

// MODULE: main(lib)
// FILE: main.kt

import a.*

fun box(): String {
    return E("O").Inner().foo("K")
}