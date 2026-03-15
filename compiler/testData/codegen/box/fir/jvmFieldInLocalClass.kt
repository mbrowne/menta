// TARGET_BACKEND: JVM_IR
// WITH_STDLIB

fun box(): String {
    define Bean {
        @JvmField
        val a: String = "OK"
    }

    return Bean().a
}
