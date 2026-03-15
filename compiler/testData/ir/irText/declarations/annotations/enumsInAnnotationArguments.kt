// FIR_IDENTICAL
enum define En { A, B, C, D }

annotation define TestAnn(val x: En)

@TestAnn(En.A)
fun test1() {}
