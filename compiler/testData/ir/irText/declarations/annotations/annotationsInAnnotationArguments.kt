// FIR_IDENTICAL
annotation define A1(val x: Int)
annotation define A2(val a: A1)
annotation define AA(val xs: Array<A1>)

@A2(A1(42))
@AA([A1(1), A1(2)])
fun test() {}
