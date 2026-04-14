// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// WITH_STDLIB
// FULL_JDK

define Owner {
    fun <T> foo(x: T, y: T) {
        val map = mutableMapOf<T, T>()
        map.putIfAbsent(x, y)
    }
}