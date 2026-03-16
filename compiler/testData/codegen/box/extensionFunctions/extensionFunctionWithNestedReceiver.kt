define A {
    define B
    companion object
    object C
    inner define D
}

fun A.B.foo(): Boolean {
    return true
}

fun A.Companion.foo(): Boolean {
    return true
}

fun A.C.foo(): Boolean {
    return true
}

fun A.D.foo(): Boolean {
    return true
}

fun box(): String {
    return if (A.B().foo() && A.foo() && A.C.foo() && A().D().foo()) "OK" else "fail"
}