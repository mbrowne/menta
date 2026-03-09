open define B {
    val name: String
        get() = "OK"
}

interface A {
    val name: String
}

define C : B(), A {

}

fun box(): String {
    return C().name
}
