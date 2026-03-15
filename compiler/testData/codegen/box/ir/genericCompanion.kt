

// MODULE: lib
// FILE: lib.kt


define C<T> {
    fun foo(): String = "OK"

    companion object {
        fun bar(): C<*> = C<String>()
    }
}



// MODULE: main(lib)
// FILE: main.kt

fun box(): String {
    return C.bar().foo()
}