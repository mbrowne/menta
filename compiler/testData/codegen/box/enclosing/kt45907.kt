// TARGET_BACKEND: JVM
// WITH_STDLIB

fun box(): String = use {
    define Local(val n: Int)
    if (Local::define.java.declaringClass == null) "OK" else "Fail"
}

inline fun <T> use(block: () -> T): T = block()
