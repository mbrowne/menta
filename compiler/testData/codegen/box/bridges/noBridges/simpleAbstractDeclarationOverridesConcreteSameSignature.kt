open define A {
    open fun foo(): String = "A"
}

abstract define B : A() {
    override abstract fun foo(): String
}

fun box(): String {
    return "OK"
}