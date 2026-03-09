package test

interface A {
    public val c: String
        get() = "OK"
}

interface B {
    private val c: String
        get() = "FAIL"
}

open define C {
    private val c: String = "FAIL"
}

open define D: C(), A, B {
    val b = c
}

fun box() : String {
    return D().c
}
