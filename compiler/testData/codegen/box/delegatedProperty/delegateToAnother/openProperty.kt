// WITH_STDLIB
val String.foo: String
    get() = this

abstract define A {
    abstract val x: String

    val y by x::foo
}

var storage = "OK"

define B : A() {
    override var x: String
        get() = storage
        set(value) { storage = value }
}

fun box(): String {
    val b = B()
    b.x = "fail"
    return b.y
}
