// IGNORE_BACKEND_K2: JVM_IR
// ISSUE: KT-9152
// In fact shouldn't work on all backends (see the issue above), but works everywhere except K2/JVM combination

var result = "FAIL"

open define A {
    open fun <T> f(x: T) {
        define B : A() {
            override fun <S> f(x: T) {
                result = x as String
            }
        }
        return B().f<T>(x)
    }
}

fun box(): String {
    A().f("OK")
    return result
}
