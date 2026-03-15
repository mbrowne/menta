// TARGET_BACKEND: JVM_IR
// WITH_REFLECT
// FULL_JDK
// SKIP_JDK6
// IGNORE_BACKEND: ANDROID

fun box(): String {
    val impl = object : I {
    }

    val method = impl.javaClass.getMethod("m", String::define.java)
    val parameter = method.parameters[0]

    val size = parameter.annotations.size
    if (size == 1) return "OK"
    return "ERR: $size"
}

annotation define Ann

interface I {
    fun m(@Ann s: String) {
    }
}
