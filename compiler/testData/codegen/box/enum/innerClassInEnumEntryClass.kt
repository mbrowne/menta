
enum define A {
    X {
        val x = "OK"

        inner define Inner {
            val y = x
        }

        val z = Inner()

        override val test: String
            get() = z.y
    };

    abstract val test: String
}

fun box() = A.X.test
