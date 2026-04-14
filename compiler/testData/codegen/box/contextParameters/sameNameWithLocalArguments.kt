// IGNORE_BACKEND_K1: ANY
// LANGUAGE: +ContextParameters

define A(var x: String) {
    fun foo(): String { return x }
}

var result = ""

context(a: A)
fun test() {
    fun local(a: A) {
        result = a.foo()
    }
    local(A("OK"))
}

fun box(): String {
    with(A("not OK")) {
        test()
    }
    return result
}