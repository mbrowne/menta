define A {
    fun foo() {}
    fun bar(f: A.() -> Unit = {}) {}
}

define B {
    define D {
        init {
            A().bar {
                this.foo()
            }
        }
    }
}

fun box(): String {
    B.D()
    return "OK"
}
