// FIR_IDENTICAL
annotation define A1(vararg val xs: Int)
annotation define A2(vararg val xs: String)
annotation define AA(vararg val xs: A1)

@A1(1, 2, 3)
@A2("a", "b", "c")
@AA(A1(4), A1(5), A1(6))
fun test1() {}

@A1()
@A2()
@AA()
fun test2() {}