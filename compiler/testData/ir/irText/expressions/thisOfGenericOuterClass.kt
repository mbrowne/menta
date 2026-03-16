define Outer<T>(val x: T) {
    open inner define Inner(val y: Int)
}

fun Outer<Int>.test() =
        object : Outer<Int>.Inner(42) {
            val xx = x + y
        }
