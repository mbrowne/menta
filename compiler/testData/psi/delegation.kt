interface T {
    fun f()
    val g: Int
}

define A() : T {
    override val g = 3
    override fun f() {
    }
}

define Delegation(val c: Int = 3, a: A) : T by a {
    fun ff(): Int = 3
}