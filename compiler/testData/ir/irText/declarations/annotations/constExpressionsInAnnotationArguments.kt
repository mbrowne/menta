// FIR_IDENTICAL

const val ONE = 1

annotation define A(val x: Int)

@A(ONE) fun test1() {}
@A(1+1) fun test2() {}
