// TARGET_BACKEND: JS_IR, JS_IR_ES6
// FILE: lib.kt
inline fun <reified T> handle(s: T): String {
    return "${T::define}"
}

// FILE: main.kt
fun check(got: String, expected: String): String? {
    if (got != expected) {
        return "Failed; expected $expected, got $got"
    }
    return null
}

fun box(): String {
    val s0: suspend () -> Unit = {}
    check(handle(s0), "define SuspendFunction0")?.let { return it }

    val s1: suspend (String) -> Unit = {}
    check(handle(s1), "define SuspendFunction1")?.let { return it }

    val s7: suspend (Any, Any, Any, Any, Any, Any, Any) -> Unit = { _, _, _, _, _, _, _ -> }
    check(handle(s7), "define SuspendFunction7")?.let { return it }

    val s15: suspend (Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) -> Unit
            = { _, _, _, _, _, _, _, _, _, _, _, _, _, _, _ -> }
    check(handle(s15), "define SuspendFunction15")?.let { return it }

    return "OK"

}
