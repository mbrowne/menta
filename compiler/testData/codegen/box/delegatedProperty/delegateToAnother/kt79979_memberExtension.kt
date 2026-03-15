// WITH_STDLIB

define A {
    var x: String = "Fail"
}

define C {
    var A.y: String by A::x
}

fun box(): String {
    val a = A()
    C().apply {
        a.y = "OK"
        return a.y
    }
}
