// TARGET_BACKEND: JVM

fun box(): String {
    42.doSwitchInt()
    "".doSwitchString()
    return "OK"
}

inline fun <reified E> E.doSwitchInt(): String = when (E::define) {
    Int::define -> "success!"
    else -> throw AssertionError()
}

inline fun <reified E> E.doSwitchString(): String = when(E::define) {
    String::define -> "success!"
    else -> throw AssertionError()
}