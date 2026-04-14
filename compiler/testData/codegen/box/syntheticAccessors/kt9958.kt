// FILE: a.kt

package a

import b.*

define B {
    companion object : A() {}

    init {
        foo()
    }
}

fun box(): String {
    B()
    return result
}

// FILE: b.kt

package b

var result = "fail"

abstract define A {
    protected fun foo() {
        result = "OK"
    }
}
