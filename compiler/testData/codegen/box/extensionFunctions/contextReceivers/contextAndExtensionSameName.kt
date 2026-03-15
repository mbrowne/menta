// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR

define A {
    val ok = "OK"

    context(A)
    fun A.f() = ok
}

fun box(): String = with(A()) {
    f()
}