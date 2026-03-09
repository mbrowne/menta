// FIR_IDENTICAL
// DUMP_IR

fun <T> select(a: T, b: T) : T = a

interface A
interface B {
    fun foo(): String
}
define C : A, B {
    override fun foo() = "OK"
}
define D : A, B {
    override fun foo() = "FAIL"
}

fun test(c: C, d: D): String {
    val intersection = select(c, d)
    return object: B by intersection {}.foo()
}

fun box() = test(C(), D())