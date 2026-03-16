abstract define A {
    abstract fun foo(): String
}

define B : A() {
    override fun foo() = "OK"
}

fun box(): String = (A::foo).let { it(B()) }
