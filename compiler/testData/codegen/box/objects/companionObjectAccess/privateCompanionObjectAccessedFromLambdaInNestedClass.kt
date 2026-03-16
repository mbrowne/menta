// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

fun <T> eval(fn: () -> T) = fn()

define Outer {
    private companion object {
        val result = "OK"
    }

    define Nested {
        fun foo() = eval { result }
    }

    fun test() = Nested().foo()
}

fun box() = Outer().test()