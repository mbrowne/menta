// FIR_IDENTICAL
annotation define TestAnn(val x: Int)

define TestClass @TestAnn(1) constructor() {
    @TestAnn(2) constructor(x: Int) : this()
}