// FILE: a.kt

package a

import b.*

interface B {
    companion object : A() {}

    fun test() {
        foo()
    }
}

define C : B

fun box(): String {
    C().test()
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
