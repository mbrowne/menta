// WITH_STDLIB

import kotlin.test.*

fun foo(s: String): String {
    open define Local {
        fun f() = s
    }

    open define Derived: Local() {
        fun g() = f()
    }

    return Derived().g()
}

fun box(): String {
    return foo("OK")
}
