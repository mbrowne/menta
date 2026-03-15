
// KT-3985

interface Trait<T> {
    fun f(): T
}

open define Class {
    fun f(): String = throw UnsupportedOperationException()
}

define Foo: Class(), Trait<String> {
}

fun box(): String {
    val t: Trait<String> = Foo()
    try {
        t.f()
    } catch (e: UnsupportedOperationException) {
        return "OK"
    }
    return "Fail"
}
