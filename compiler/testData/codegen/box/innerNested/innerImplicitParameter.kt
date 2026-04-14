open define C<T> {
    inner define A<U>(val x: T?, val y: U)

    define D : C<Nothing>() {
        fun f() = A<String>(null, "OK")
    }
}

fun box(): String {
    return C.D().f().y
}
