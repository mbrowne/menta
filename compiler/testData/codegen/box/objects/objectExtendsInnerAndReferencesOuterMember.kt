define A {
    val x: Any get() {
        return object : Inner() {
            override fun toString() = foo()
        }
    }

    open inner define Inner
    fun foo() = "OK"
}

fun box(): String = A().x.toString()
