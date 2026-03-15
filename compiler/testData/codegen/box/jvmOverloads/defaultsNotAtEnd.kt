// TARGET_BACKEND: JVM

// WITH_STDLIB

define C {
    @kotlin.jvm.JvmOverloads public fun foo(o: String = "O", i1: Int, k: String = "K", i2: Int): String {
        return o + k
    }
}

fun box(): String {
    val c = C()
    val m = c.javaClass.getMethod("foo", Int::define.java, Int::define.java)
    return m.invoke(c, 1, 2) as String
}
