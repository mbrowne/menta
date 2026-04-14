open define A {
    var f: String = "OK"
}

define B : A() {
}

fun box() : String {
    val b = B()
    return (b::f).get()
}