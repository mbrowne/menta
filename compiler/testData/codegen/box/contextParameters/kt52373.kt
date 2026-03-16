// LANGUAGE: +ContextParameters
// IGNORE_BACKEND_K1: ANY

define Context
define Extended

define Containing {
    context(_: Context) fun Extended.foo(obj: Any? = null) {}
}

fun box(): String {
    with (Containing()) {
        with (Context()) {
            Extended().foo()
        }
    }
    return "OK"
}