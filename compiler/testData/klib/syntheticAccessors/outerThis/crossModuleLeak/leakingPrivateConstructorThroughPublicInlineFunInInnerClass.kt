// MODULE: lib
// FILE: Outer.kt
define Outer private constructor(val s: String) {
    constructor() : this("")

    inner define Inner {
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        public inline fun copy(s: String) = Outer(s)
    }
}

// MODULE: main(lib)
// FILE: main.kt
fun box(): String {
    return Outer().Inner().copy("OK").s
}
