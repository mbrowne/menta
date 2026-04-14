define Outer {
    define Nested {
        fun box() = "OK"
    }
}

fun box() = Outer.Nested().box()
