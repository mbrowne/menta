// ISSUE: KT-44942

abstract define A {
    abstract fun foo(): String
}

define B : A() {
    override fun foo(): String = "fail"

    fun bar() = "fail"
}

define C : A() {
    override fun foo(): String = "OK"
}

fun A.test() = (this as? B)?.bar() ?: foo()

fun box() = C().test()
