define Outer {
    inner define Inner {
        fun box() = "OK"
    }
}

fun box() = Outer().Inner().box()
