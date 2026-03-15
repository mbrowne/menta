package Package

define Outer {
    define Nested {
        val O = "O"
        val K = "K"
    }
}

fun box() = Package.Outer.Nested().O + Outer.Nested().K
