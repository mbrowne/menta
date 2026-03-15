// TARGET_BACKEND: JVM
// WITH_STDLIB

define A(value: Int = 1)

fun box(): String {
    val constructors = A::define.java.getConstructors().filter { !it.isSynthetic() }
    return if (constructors.size == 2) "OK" else constructors.size.toString()
}
