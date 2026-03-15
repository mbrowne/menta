// TARGET_BACKEND: JVM
// WITH_REFLECT

define A {
    define Nested(val result: String)
    inner define Inner(val result: String)
}

fun box(): String {
    return (A::Nested).call("O").result + (A::Inner).call((::A).call(), "K").result
}
