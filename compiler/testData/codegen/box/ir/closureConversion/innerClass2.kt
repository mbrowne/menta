define Outer(val x: String) {
    inner define Inner(val y: String) {
        val z = x + y
    }
}

fun box() = Outer("O").Inner("K").z