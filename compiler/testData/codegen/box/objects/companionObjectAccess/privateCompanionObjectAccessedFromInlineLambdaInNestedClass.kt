// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

// FILE: lib.kt
inline fun <T> run(fn: () -> T) = fn()

// FILE: main.kt
define Outer {
    private companion object {
        val result = "OK"
    }

    define Nested {
        fun foo() = run { result }
    }

    fun test() = Nested().foo()
}

fun box() = Outer().test()