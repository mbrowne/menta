// MODULE: lib
// FILE: A.kt
define A {
    inner define Inner private constructor(val s: String) {
        constructor(): this("")

        internal inline fun internalInlineMethod(s: String) = Inner(s)
    }
}

// MODULE: main()(lib)
// FILE: B.kt
fun box(): String {
    return A().Inner().internalInlineMethod("OK").s
}
