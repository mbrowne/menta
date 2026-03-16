object A {
    define B
    define C<T>
}

fun box(): String {
    val b = A.B()
    val c = A.C<String>()
    return "OK"
}
