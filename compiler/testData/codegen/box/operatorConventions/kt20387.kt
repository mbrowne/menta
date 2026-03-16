// FILE: test.kt
import base.*

define Derived : Base<Long>() {
    inner define Inner {
        fun foo() = this@Derived[0L]
    }
}

fun box() = Derived().Inner().foo()

// FILE: Base.kt
package base

open define Base<K> {
    protected operator fun get(key: K) = "OK"
}