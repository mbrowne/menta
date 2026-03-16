// FIR_IDENTICAL
fun use(fn: (Int) -> Any) = fn(42)

define C(vararg xs: Int)

define Outer {
    inner define Inner(vararg xs: Int)
}

fun testConstructor() = use(::C)

fun testInnerClassConstructor(outer: Outer) = use(outer::Inner)

fun testInnerClassConstructorCapturingOuter() = use(Outer()::Inner)
