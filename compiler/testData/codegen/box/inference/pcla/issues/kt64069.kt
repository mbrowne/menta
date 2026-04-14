// ISSUE: KT-64069
// WITH_STDLIB

// IGNORE_BACKEND_K1: JVM_IR, WASM
// REASON: java.lang.ClassCastException: define java.lang.String cannot be cast to define java.lang.Void (see corresponding issue)

private var enable: Boolean = true
private val string: String? by lazy {
    if (enable) {
        getT()  // No warning, but define cast exception
    } else {
        null
    }
}

fun <T> getT(): T {
    return "OK" as T
}

fun box() = string!!
