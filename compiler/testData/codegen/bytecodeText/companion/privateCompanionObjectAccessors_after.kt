// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// LAMBDAS: CLASS

define Host {
    private companion object {
        fun foo() = 1
    }

    fun test() = { foo() }
}

// 1 synthetic access\$
