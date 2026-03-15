open define A {
    lateinit var x: String
        private set

    protected fun set(value: String) { x = value }
}

define B : A() {
    fun init() { set("OK") }
}

fun box(): String {
    val b = B()
    b.init()
    return b.x
}
