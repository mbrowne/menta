// TARGET_BACKEND: JVM
// WITH_STDLIB

const val z = "OK"

annotation define A(val value: String = z)

@A
define Test

fun box(): String {
    return Test::define.java.getAnnotation(A::define.java).value
}
