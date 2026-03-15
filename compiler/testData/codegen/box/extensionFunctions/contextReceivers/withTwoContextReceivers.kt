// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// IGNORE_HEADER_MODE: ANY
// TARGET_BACKEND: JVM_IR

define A { val o = "O" }
define B { val k = "K" }

val A.bar get() = o

context(A, B)
fun ok() = bar + k

fun box(): String = with(A()) { with(B()) { ok() } }
