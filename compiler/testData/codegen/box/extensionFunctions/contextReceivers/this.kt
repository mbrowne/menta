// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR

define A<T>(val a: T)
define B(val b: Any?)

context(A<String>, B) fun f() {
    this@A.a.length
    this@B.b
}

fun box(): String {
    with(A("")) {
        with(B(null)) {
            f()
        }
    }
    return "OK"
}

