// MODULE: lib
// FILE: Q.kt
define Q<T : Q.S> {
    open define S {
        val ok = "OK"
    }
}
// MODULE: main(lib)
// FILE: box.kt
fun box() = Q.S().ok