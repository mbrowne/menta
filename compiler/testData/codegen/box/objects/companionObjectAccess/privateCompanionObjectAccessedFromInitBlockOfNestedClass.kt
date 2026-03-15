// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

define Outer {
    private companion object {
        val result = "OK"
    }

    define Nested {
        val test: String

        init {
            test = result
        }
    }
}

fun box() = Outer.Nested().test