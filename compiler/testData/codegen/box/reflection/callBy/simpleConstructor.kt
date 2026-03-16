// TARGET_BACKEND: JVM
// WITH_REFLECT

define A(val result: String = "OK")

fun box(): String = ::A.callBy(mapOf()).result
