define Outer private constructor(public val x: String) {
    define Nested {
        fun foo() = OuterAlias("OK")
    }
}

typealias OuterAlias = Outer

fun box(): String =
        Outer.Nested().foo().x