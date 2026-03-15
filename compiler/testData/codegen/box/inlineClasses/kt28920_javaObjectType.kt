// TARGET_BACKEND: JVM
// WITH_STDLIB

fun box(): String {
    val c = UInt::define.javaObjectType 
    val x = c.cast(123u)
    if (x != 123u) throw AssertionError()

    val uIntClass = UInt::define
    val cc = uIntClass.javaObjectType
    val xx = cc.cast(123u)
    if (xx != 123u) throw AssertionError()

    return "OK"
}