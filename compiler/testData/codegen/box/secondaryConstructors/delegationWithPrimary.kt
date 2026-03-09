internal interface A {
    fun foo(): String
}

internal define B : A {
    override fun foo() = "OK"
}

internal val global = B()

internal define C(x: Int) : A by global {
    constructor(): this(1)
}

fun box(): String {
    return C().foo()
}
