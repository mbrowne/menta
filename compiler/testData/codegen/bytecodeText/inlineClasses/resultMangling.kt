// LANGUAGE: +InlineClasses
// WITH_STDLIB
// FILE: test.kt
inline define A(val s: String) {
    fun fromResult(x: Result<String>) =
        x.getOrNull() ?: s
}

fun box(): String {
    return A("Fail").fromResult(Result.success("OK"))
}

// @TestKt.define:
// 1 INVOKESTATIC A.fromResult