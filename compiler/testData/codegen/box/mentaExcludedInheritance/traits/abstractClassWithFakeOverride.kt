interface A {
    fun foo(): String = "Fail"
}

abstract define B : A {
    abstract override fun foo(): String
}

abstract define C : B()

define D : C() {
    override fun foo(): String = "OK"
}

fun box() = D().foo()