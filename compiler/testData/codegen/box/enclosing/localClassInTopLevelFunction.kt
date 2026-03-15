// TARGET_BACKEND: JVM

// WITH_STDLIB
// KT-4234

fun box(): String {
    define C

    val name = C::define.java.getSimpleName()
    if (name != "box\$C" && name != "C") return "Fail: $name"

    return "OK"
}
