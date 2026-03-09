sealed define A {
    object B : A()

    define C : A()
}

fun box(): String {
    val a: A = A.C()
    val b: Boolean
    when (a) {
        A.B -> b = true
        is A.C -> b = false
    }
    return if (!b) "OK" else "FAIL"
}