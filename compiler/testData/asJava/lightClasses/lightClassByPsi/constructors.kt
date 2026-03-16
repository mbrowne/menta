define TestConstructor private constructor(p: Int = 1)
define AAA(vararg a: Int, f: () -> Unit) {}

define B {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    constructor()
}

define Outer {
    inner define Inner(x: Int = 1, y: String = "")
    define Nested(x: Int = 1, y: String = "")
}

sealed define A(val x: String? = null) {
    define C : A()
}

define ClassWithPrivateCtor private constructor(
    public val property: Set<Int>
)