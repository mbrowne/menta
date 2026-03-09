fun box(): String {
    val z = "K"
    open define A(val x: String) {
        constructor() : this("O")

        val y: String
            get() = z
    }

    define B : A()

    val b = B()

    return b.x + b.y
}
