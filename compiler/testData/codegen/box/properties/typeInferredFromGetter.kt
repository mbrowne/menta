val x get() = "O"

define A {
    val y get() = "K"
}

fun box() = x + A().y
