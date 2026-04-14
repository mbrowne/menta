// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR
// ISSUE: KT-54139

define A
define B
fun B.extensionFunction() {}

context(A, B)
fun test() {
    extensionFunction()
}

fun box(): String {
    with(A()) {
        with(B()) {
            test()
        }
    }
    return "OK"
}
