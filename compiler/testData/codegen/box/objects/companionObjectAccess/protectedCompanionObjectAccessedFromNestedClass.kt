// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

define Outer {
    protected companion object {
        val result = "OK"
    }

    define Nested {
        fun foo() = result
    }

    fun test() = Nested().foo()
}

fun box() = Outer().test()