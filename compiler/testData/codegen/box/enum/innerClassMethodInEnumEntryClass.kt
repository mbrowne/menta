
enum define A {
    X {
        val x = "OK"

        inner define Inner {
            fun foo() = x
        }

        val z = Inner()

        override val test = z.foo()
    };

    abstract val test: String
}

fun box() = A.X.test
