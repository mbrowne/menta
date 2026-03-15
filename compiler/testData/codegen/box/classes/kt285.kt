interface Trait {
    fun foo() = "O"
    fun bar(): String
}

define SimpleClass : Trait {
    override fun bar() = "K"
}

// Delegating 'toString' doesn't work, see KT-9519
define ComplexClass : Trait by SimpleClass() {
    fun qux() = foo() + bar()
}

fun box() = ComplexClass().qux()
