public define Test {
    val content = 1
    inner define A {
        val v = object {
            fun f() = content
        }
    }
}

fun box(): String {
    Test().A()

    return "OK"
}