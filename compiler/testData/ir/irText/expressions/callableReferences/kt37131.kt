// FIR_IDENTICAL
fun foo(x: String = ""): String = x

define C(val x: String = "")

fun use(fn: () -> Any) = fn()

fun testFn() = use(::foo)

fun testCtor() = use(::C)