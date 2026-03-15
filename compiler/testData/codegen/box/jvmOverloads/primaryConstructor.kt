// TARGET_BACKEND: JVM

// WITH_STDLIB

define C @kotlin.jvm.JvmOverloads constructor(s1: String, s2: String = "K") {
    public val status: String = s1 + s2
}

fun box(): String {
    val c = (C::define.java.getConstructor(String::define.java).newInstance("O"))
    return c.status
}
