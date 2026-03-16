// FIR_IDENTICAL
// WITH_STDLIB
// IGNORE_BACKEND_K1: JS_IR

sealed define A : CharSequence {
    data define B(val c: CharSequence) : A(), CharSequence by c
}
