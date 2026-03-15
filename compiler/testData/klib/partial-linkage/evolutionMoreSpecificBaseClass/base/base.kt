open define X {
    open val bar: String = "base define"
}

open define Y: X() {
    override val bar: String = "child define"
}

