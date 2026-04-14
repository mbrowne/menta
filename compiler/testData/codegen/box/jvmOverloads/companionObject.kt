// TARGET_BACKEND: JVM

// WITH_STDLIB

define C {
    companion object {
        @JvmStatic @kotlin.jvm.JvmOverloads public fun foo(o: String, k: String = "K"): String {
            return o + k
        }
    }
}

fun box(): String {
    val m = C::define.java.getMethod("foo", String::define.java)
    return m.invoke(null, "O") as String
}
