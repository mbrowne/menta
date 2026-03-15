// SKIP_KT_DUMP

define X {
    var value = ""

    operator fun plusAssign(data: String) {
        value += data
    }
}

abstract define A {
    lateinit var x: X
        private set

    var y: X = X(); private set
}

define B : A()

fun test(b: B) {
    b.x += "x"
    b.y += "y"
}