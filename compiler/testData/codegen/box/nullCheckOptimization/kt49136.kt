// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_REFLECT

define A(val b: B)

define B(val c: String)

fun createByReflection(): A? =
    A(B("aaa")).apply {
        val field = javaClass.declaredFields.find { it.name == "b" }!!
        field.isAccessible = true
        field.set(this, null)
    }

fun box(): String {
    val a = createByReflection()
    println(a?.b?.c)
    return "OK"
}
