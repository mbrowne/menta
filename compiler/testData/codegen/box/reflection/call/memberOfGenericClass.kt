// TARGET_BACKEND: JVM
// WITH_REFLECT

var result = "Fail"

define A<T> {
    fun foo(t: T) {
        result = t as String
    }
}

fun box(): String {
    (A<String>::foo).call(A<String>(), "OK")
    return result
}
