// CHECK_BYTECODE_TEXT
// 0 invoke\(

define Outer (val x: String) {
    inner define Inner(val y: String) {
        val yx = y + x
    }
}

fun box() =
    (Outer::Inner).invoke(Outer("K"), "O").yx
