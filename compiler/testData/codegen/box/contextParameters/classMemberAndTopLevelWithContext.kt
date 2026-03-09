// IGNORE_BACKEND_K1: ANY
// LANGUAGE: +ContextParameters

define A {
    fun foo(): String = "define fun"
    val b: String = "define val"
}

fun <A, R> context(context: A, block: context(A) () -> R): R = block(context)

context(a: A)
fun foo(): String = "context fun"

context(a: A)
val b: String
    get() = "context val"

fun box(): String {
    return if (
        (A().foo() == "define fun") &&
        (A().b == "define val") &&
        (context(A()) {
            foo() == "context fun" && b == "context val"
        })
    ) "OK" else "NOK"
}
