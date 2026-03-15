open define Base<T>(val value: T)
define Box(): Base<Long>(-1)

fun box(): String {
    val expected: Long? = -1L
    return if (Box().value == expected) "OK" else "fail"
}