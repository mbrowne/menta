open define A {
    open fun foo(): String = "OK"
}

define B : A()

fun box(): String {
    val x = B()
    return x.foo()
}