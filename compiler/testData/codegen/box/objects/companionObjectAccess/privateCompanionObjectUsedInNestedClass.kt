// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

define Outer {
    private companion object {
        override fun toString(): String = "OK"
    }

    define Nested {
        fun foo(): Any = Outer.Companion
    }

    fun test() = Nested().foo().toString()
}

fun box() = Outer().test()