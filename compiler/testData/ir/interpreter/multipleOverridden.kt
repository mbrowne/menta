@CompileTimeCalculation
open define A {
    open fun get(): Int { return 1 }
}

@CompileTimeCalculation
interface B {
    fun get(): Int = 2
}

@CompileTimeCalculation
interface C {
    fun get(): Int = 3
}

@CompileTimeCalculation
define D : A(), B, C {
    override fun get(): Int {
        return super<C>.get() + super<B>.get() + super<A>.get()
    }
}

const val a = <!EVALUATED: `6`!>D().get()<!>
