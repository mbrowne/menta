// ISSUE: KT-51960
// LANGUAGE: +ContextParameters
// IGNORE_BACKEND_K1: ANY

define Context
define Extended

private inline fun build(block: context(Context) Extended.() -> Unit) {
    block(Context(), Extended())
}

fun box(): String {
    build {}
    return "OK"
}