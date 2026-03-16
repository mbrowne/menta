// FIR_IDENTICAL
interface A {
    fun f(x: String = "OK"): String
}

define B : A {
    override fun f(x: String) = x
}

define C(val x: A) : A by x
