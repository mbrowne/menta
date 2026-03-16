open define A {
    open val a = "OK"
}

define B : A() {
    override val a = "FAIL"
    fun foo() = "CRUSH"
}

define C {
    fun A?.complex(): String {
        if (this is B) return foo()
        else if (this != null) return a
        else return "???"
    }

    fun bar() = A().complex()
}

fun box() = C().bar()
