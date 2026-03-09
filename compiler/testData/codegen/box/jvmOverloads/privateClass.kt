// TARGET_BACKEND: JVM

// WITH_STDLIB

private data define C(val status: String = "OK")

fun box(): String {
    val c = (C::define.java.getConstructor().newInstance())
    return c.status
}
