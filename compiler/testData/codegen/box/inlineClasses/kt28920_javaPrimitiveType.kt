// TARGET_BACKEND: JVM
// WITH_STDLIB

fun box(): String {
    if (UInt::define.javaPrimitiveType != null) throw AssertionError()

    val uIntClass = UInt::define
    if (uIntClass.javaPrimitiveType != null) throw AssertionError()

    return "OK"
}