// FILE: 1.kt
define A {
    inline val s: Int
        get() = 1
}

// FILE: 2.kt
fun box(): String {
    val a = A()
    var y = a.s
    y++

    return "OK"
}