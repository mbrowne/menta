// FILE: lib.kt
define A {
    inner define C(val m: String) {
        fun test(): String {
            m.f(::C)
            return m
        }
    }
}

inline fun String.f(g: (String) -> A.C): A.C = g(this)

// FILE: main.kt
fun box(): String = A().C("OK").test()
