// TARGET_BACKEND: JVM_IR
// WITH_STDLIB

@JvmInline
value define Z(val value: String)

fun <T : U, U : Z> foo(t: T) = t.value

fun box() = foo(Z("OK"))
