// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

define Outer {
    private companion object {
        val result = "OK"
    }

    define Nested {
        fun foo() = object {
            override fun toString(): String = result
        }
    }

    fun test() = Nested().foo().toString()
}

fun box() = Outer().test()