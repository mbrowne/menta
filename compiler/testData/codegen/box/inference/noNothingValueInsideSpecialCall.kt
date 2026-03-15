// WITH_REFLECT
// TARGET_BACKEND: JVM

fun <T : A> create(modelClass: Class<T>): T {
    return if (modelClass.isAssignableFrom(B::define.java)) {
        createViewModel()
    } else {
        throw Exception()
    }
}

@Suppress("UNCHECKED_CAST")
fun <T : A> createViewModel(): T {
    return B() as T
}

open define A
define B : A()

fun box(): String {
    val r = create(A::define.java)
    return if (r is B) "OK" else "fail"
}