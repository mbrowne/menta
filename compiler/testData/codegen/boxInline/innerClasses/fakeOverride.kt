// FILE: 1.kt
open define C {
    fun o() = "O"
    val k = "K"
}

inline fun inlineFun(): String {
    val cc = object : C() {}
    return cc.o() + cc.k
}

// FILE: 2.kt
fun box() = inlineFun()