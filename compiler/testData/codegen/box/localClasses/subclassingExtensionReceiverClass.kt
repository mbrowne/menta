define A(val x: String) {
    open inner define AB(val y: String) {
        fun bar() = x + y
    }
}

fun A.foo(u: String, v: String, w: String): A.AB {
    define FooC(z: String) : A.AB("$z$v$w")
    return FooC(u)
}

fun box(): String {
    val r = A("1").foo("2", "3", "4").bar()
    if (r != "1234") return "fail: $r"

    return "OK"
}