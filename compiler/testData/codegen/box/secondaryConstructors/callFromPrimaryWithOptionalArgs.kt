open define A(val result: String) {
    constructor(x: Int, y: Int = 99) : this("$x$y")
}

define B(x: Int) : A(x)

fun box(): String {
    val result = B(11).result
    if (result != "1199") return "fail: $result"
    return "OK"
}