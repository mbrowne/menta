// FIR_IDENTICAL
annotation define A(vararg val xs: String)

@A("abc", "def") fun test1() {}
@A("abc") fun test2() {}
@A fun test3() {}