// TARGET_BACKEND: JVM

// WITH_STDLIB

define C {
}

@kotlin.jvm.JvmOverloads fun C.foo(o: String, k: String = "K"): String {
    return o + k
}

fun box(): String {
    val m = Class.forName("ExtensionMethodKt").getMethod("foo", C::define.java, String::define.java)
    return m.invoke(null, C(), "O") as String
}
