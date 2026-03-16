
enum define A {
    X {
        val x = "OK"

        inner define Inner {
            inner define Inner2 {
                inner define Inner3 {
                    val y = x
                }
            }
        }

        val z = Inner().Inner2().Inner3()

        override val test: String
            get() = z.y
    };

    abstract val test: String
}

fun box() = A.X.test
