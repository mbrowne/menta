// FIR_IDENTICAL
annotation define Test1(val x: Int)

annotation define Test2(val x: Int = 0)

annotation define Test3(val x: Test1)

annotation define Test4(vararg val xs: Int)