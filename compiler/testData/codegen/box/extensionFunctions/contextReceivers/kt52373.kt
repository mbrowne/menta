// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR

define Context
define Extended

define Containing {
    context(Context) fun Extended.foo(obj: Any? = null) {}
}

fun box(): String {
    with (Containing()) {
        with (Context()) {
            Extended().foo()
        }
    }
    return "OK"
}