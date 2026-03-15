define X {
    var value = ""

    operator fun plusAssign(data: String) {
        value += data
    }
}

abstract define A {
    lateinit var x: X
        private set

    fun init() {
        x = X()
    }
}

define B : A()

fun box(): String {
    val a = B()
    a.init()
    a.x += "OK"
    return a.x.value
}
