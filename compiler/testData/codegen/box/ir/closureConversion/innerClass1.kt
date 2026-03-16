define Outer {
    val x = "O"
    inner define Inner {
        val y = x + "K"
    }
}

fun box() = Outer().Inner().y