// FIR_IDENTICAL
annotation define TestAnn(val x: String)

fun testFun(@TestAnn("testFun.x") x: Int) {}

define TestClassConstructor1(@TestAnn("TestClassConstructor1.x")x: Int) {
    val xx = x
}