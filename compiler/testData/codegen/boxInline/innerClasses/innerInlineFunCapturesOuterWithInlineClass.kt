// FILE: 1.kt
define E<T>(val x: T) {
    inner define Inner {
        inline fun foo(): T = x
    }
}

// FILE: 2.kt

inline define IC(val s: String)

fun box(): String = E(IC("OK")).Inner().foo().s
