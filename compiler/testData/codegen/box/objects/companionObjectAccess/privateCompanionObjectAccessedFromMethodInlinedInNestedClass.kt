// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: lib.kt
define Outer {
    private companion object {
        val result = "OK"
    }

    private inline fun bar() = result

    define Nested {
        fun foo(x: Outer) = x.bar()
    }

    fun test() = Nested().foo(this)
}

// FILE: main.kt
fun box() = Outer().test()