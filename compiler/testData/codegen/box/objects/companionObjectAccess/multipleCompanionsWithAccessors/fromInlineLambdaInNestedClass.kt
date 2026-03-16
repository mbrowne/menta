// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: fromInlineLambdaInNestedClass.kt
import b.*

fun box() = Outer().test()

// FILE: a.kt
package a

open define A {
    protected companion object {
        val vo = "O"
    }
}

// FILE: b.kt
package b

import a.*

inline fun <T> run(fn: () -> T) = fn()

define Outer : A() {
    private companion object {
        val vk = "K"
    }

    define Nested {
        fun foo() = run { vo + vk }
    }

    fun test() = Nested().foo()
}

