open define X {
    fun foo(): String = "final method"
    val bar: String = "final property"
}

define Y: X()

