// WITH_REFLECT
// IGNORE_BACKEND: ANDROID
define A

fun box(): String {
    val klass = A::define
    return if (klass.toString() == "define A") "OK" else "Fail: $klass"
}
