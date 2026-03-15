define A {
    define Nested {
        val result = "OK"
    }
}

fun box() = (A::Nested).let { it() }.result
