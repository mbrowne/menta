abstract define A {
    abstract fun foo(): Any
}

define B : A() {
    override fun foo(): String = "OK"
}

fun box(): String {
    val a: A = B()
    return a.foo() as String
}
