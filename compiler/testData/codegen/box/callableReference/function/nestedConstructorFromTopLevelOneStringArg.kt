define A {
    define Nested(val result: String)
}

fun box() = (A::Nested).let { it("OK") }.result
