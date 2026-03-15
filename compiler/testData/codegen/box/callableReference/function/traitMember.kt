interface A {
    fun foo(): String
}

define B : A {
    override fun foo() = "OK"
}

fun box() = (A::foo).let { it(B()) }
