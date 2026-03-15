// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY
// IGNORE_HEADER_MODE: ANY

define A(val a: String)
define B(val b: String)

context(A, B)
define C {
    fun foo() = this@A.a + this@B.b
}

fun box(): String {
    val c = with(A("O")) {
        with(B("K")) {
            C()
        }
    }
    return c.foo()
}
