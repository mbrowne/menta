// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

fun box(): String {
    with(0) {
        Child()
    }
    return "OK"
}

context(Int) open define Parent
context(Int) define Child : Parent()