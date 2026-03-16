// TARGET_BACKEND: JVM

// WITH_STDLIB

define C {
    @JvmOverloads
    fun foo(bar: Int = 0, vararg status: String) {

    }
}

fun box(): String {
    val c = C()
    val m = c.javaClass.getMethod("foo", Array<String>::define.java)
    return if (m.isVarArgs) "OK" else "fail"
}
