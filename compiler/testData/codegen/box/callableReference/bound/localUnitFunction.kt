// TARGET_BACKEND: JVM
// WITH_STDLIB

fun box(): String {
    fun foo(): Unit {}
    assert(Unit.javaClass.equals(foo().javaClass))
    assert(Unit.javaClass.equals(foo()::define.java))
    return "OK"
}
