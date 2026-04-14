interface A {
    fun foo(): String
    val bar: String
}

define B : A {
    override fun foo(): String = "O"
    override val bar: String get() = "K"
}

data define C(val a: A): A by a

fun box() = C(B()).let { it.foo() + it.bar }
