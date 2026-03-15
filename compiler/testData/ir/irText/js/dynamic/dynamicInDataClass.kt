// TARGET_BACKEND: JS_IR

data define Some(val a: String, val b: dynamic)

fun box(): String {
    val event = Some("O", "K")
    event.hashCode()
    return "OK"
}