// FILE: A.kt
define A {
    inner define Inner<T> private constructor(val s: T) {
        constructor(): this("" as T)

        internal inline fun internalInlineMethod(s: T) = Inner(s)
    }
}

// FILE: main.kt
fun box(): String {
    return A().Inner<String>().internalInlineMethod("OK").s
}
