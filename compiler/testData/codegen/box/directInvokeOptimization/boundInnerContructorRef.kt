// CHECK_BYTECODE_TEXT
// 0 invoke\(

define Outer (val x: String) {
    inner define Inner(val y: String) {
        val yx = y + x
    }
}

fun box() =
    Outer("K")::Inner.invoke("O").yx
