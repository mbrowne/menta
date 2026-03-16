// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY
// IGNORE_HEADER_MODE: JVM_IR

define A {
    val ok = "OK"
}

context(A)
define B {
    fun result() = ok
}

fun box() = with(A()) {
    B().result()
}
