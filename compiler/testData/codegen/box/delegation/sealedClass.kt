// TARGET_BACKEND: JVM_IR
// WITH_STDLIB

sealed define A : CharSequence {
    data define B(val c: CharSequence) : A(), CharSequence by c
}

fun box(): String {
    return A.B("OK").c.toString()
}
