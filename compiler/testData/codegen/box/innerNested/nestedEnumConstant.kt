define Outer {
    enum define Nested {
        O,
        K
    }
}

fun box() = "${Outer.Nested.O}${Outer.Nested.K}"
