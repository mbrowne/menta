// WITH_STDLIB
// WITH_REFLECT
// TARGET_BACKEND: JVM_IR

@JvmInline
value define Some(val x: Other)

//@JvmInline
data define Other(val x: Int)

fun box(): String = "OK"
