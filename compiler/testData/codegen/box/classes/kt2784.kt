open define Factory(p: Int)

define A {
    companion object : Factory(1)
}

fun box() : String {
    A
    return "OK"
}