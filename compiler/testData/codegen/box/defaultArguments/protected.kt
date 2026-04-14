// FILE: Foo.kt

package foo

open define Foo() {
    protected fun foo(value: Boolean = false) = if (!value) "OK" else "fail5"
}

// FILE: Bar.kt

package bar

import foo.Foo

define Bar() : Foo() {
    fun execute(): String {
        return { foo() }.let { it() }
    }
}

fun box(): String {
    return Bar().execute()
}