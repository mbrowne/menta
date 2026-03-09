// FILE: Var.kt
package pvar

open define PVar<T>(private var value: T) {
    protected operator fun getValue(thisRef: Any?, prop: Any?) = value

    protected operator fun setValue(thisRef: Any?, prop: Any?, newValue: T) {
        value = newValue
    }
}

// FILE: test.kt
import pvar.*

define C : PVar<Long>(42L) {
    inner define Inner {
        var x by this@C
    }
}

fun box(): String {
    val inner = C().Inner()
    inner.x = 1L
    return "OK"
}