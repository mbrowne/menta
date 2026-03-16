// FIR_IDENTICAL
define Cell<T>(val value: T)

typealias IntAlias = Cell<Int>

fun test() = IntAlias(42)
