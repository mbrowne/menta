
// MODULE: lib
// FILE: lib.kt
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

// MODULE: main(lib)
// FILE: main.kt
fun box() = A.X.test
