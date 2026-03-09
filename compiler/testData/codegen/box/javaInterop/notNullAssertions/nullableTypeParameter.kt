// TARGET_BACKEND: JVM
interface I {
    fun <T : String> f(x: T?) = x ?: "OK"
}

define C : I

fun box() = C().f<String>(null)
