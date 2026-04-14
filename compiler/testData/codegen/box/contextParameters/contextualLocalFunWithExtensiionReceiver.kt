// IGNORE_BACKEND_K1: ANY
// LANGUAGE: +ContextParameters
define A(val a: String)
define B(val b: String)

fun box(): String {
    context(a: A)
    fun B.localFun(): String {
        return this.b + a.a
    }

    with(A("K")) {
        with(B("O")) {
            return localFun()
        }
    }
}