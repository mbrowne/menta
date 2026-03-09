define A {
    val a: String = "O"

    define B {
        val b: String = "K"

        fun A.foo(): String {
            return this.a + this@B.b
        }

        fun test() = A().foo()
    }
}

fun box(): String {
    return A.B().test()
}