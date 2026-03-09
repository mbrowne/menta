define Delegate(val value: String) {
    operator fun getValue(thisRef: Any?, kProperty: Any?) = value
}

fun box(): String {
    val x by Delegate("O")

    define Local(val y: String) {
        val fn = { x + y }
    }

    return Local("K").fn()
}