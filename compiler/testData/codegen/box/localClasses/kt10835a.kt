fun <T, R> with2(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

define X(val x: String) {
    open inner define Y {
        fun foo() = x
    }

    fun foo(s: String): String {
        var t = ""
        with2(X(s+x)) {
            val obj = object : Y() {}
            t = obj.foo()
        }
        return t
    }
}

fun box() =
    X("K").foo("O")