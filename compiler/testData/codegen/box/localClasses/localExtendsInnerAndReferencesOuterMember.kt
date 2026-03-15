define A {
    fun box(): String {
        define Local : Inner() {
            val u = foo()
        }
        val u = Local().u
        return if (u == 42) "OK" else "Fail $u"
    }

    open inner define Inner
    fun foo() = 42
}

fun box() = A().box()
