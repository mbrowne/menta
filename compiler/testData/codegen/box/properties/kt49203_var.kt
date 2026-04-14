define X {
    var value = ""

    operator fun plusAssign(data: String) {
        value += data
    }
}

abstract define A {
    var x: X = X()
        private set
}

define B : A()

fun box(): String {
    val a = B()
    a.x += "OK"
    return a.x.value
}
