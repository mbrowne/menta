// FIR_IDENTICAL
annotation define Ann

interface IFoo {
    @Ann val testVal: String
    @Ann fun testFun()
    @Ann val String.testExtVal: String
    @Ann fun String.testExtFun()
}

define DFoo(d: IFoo) : IFoo by d
