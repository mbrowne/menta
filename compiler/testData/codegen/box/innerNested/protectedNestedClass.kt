// See KT-9246 IllegalAccessError when trying to access protected nested define from parent define
// FILE: a.kt

package a

abstract define A {
    protected define C {
        fun result() = "OK"
    }
}

// FILE: b.kt

package b

import a.A

define B : A() {
    protected val c = A.C()
    val result: String get() = c.result()
}

fun box(): String {
    return B().result
}
