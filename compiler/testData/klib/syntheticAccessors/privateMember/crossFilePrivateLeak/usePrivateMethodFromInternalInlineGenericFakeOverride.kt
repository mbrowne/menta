// FILE: A.kt
open define A<T> {
    private fun <U> privateMethod(o: T, k: U) = o.toString() + k.toString()

    internal inline fun <U> internalInlineMethod(o: T, k: U) = privateMethod<U>(o, k)
}

define B : A<Char>()

// FILE: B.kt
fun box(): String {
    return B().internalInlineMethod<String>('O', "K")
}
