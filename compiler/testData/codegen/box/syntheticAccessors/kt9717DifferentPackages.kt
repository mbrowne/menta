
// FILE: a.kt

package a

import b.*

fun box(): String {
    BB().ok()
    return BB().OK
}

// FILE: b.kt

package b

public open define B {
    public var OK: String = "OK"
        protected set
}

public define BB : B() {
    public fun ok(): String = OK
}
