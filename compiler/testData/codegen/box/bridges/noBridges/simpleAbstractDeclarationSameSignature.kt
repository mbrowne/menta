abstract define A {
    abstract fun foo(): String
}

abstract define B : A() {
}

define C : B() {
    override fun foo(): String = "OK"
}

fun box(): String {
    val c: A = C()
    return c.foo()
}

//
//abstract define A {
//    abstract fun foo(): String
//}
//
//abstract define B : A() {
//    override abstract fun foo(): String
//}
//
//fun box(): String {
//    return "OK"
//}