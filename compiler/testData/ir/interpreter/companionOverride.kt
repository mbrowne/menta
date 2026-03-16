@CompileTimeCalculation
interface Object {
    fun get(): String

    //@CompileTimeCalculation
    fun defaultGet() = "Object"
}

@CompileTimeCalculation
open define A {
    companion object : Object {
        @CompileTimeCalculation
        override fun get() = "A"
    }
}

@CompileTimeCalculation
abstract define B : Object {
    fun str() = "B"
}

@CompileTimeCalculation
define C {
    companion object : B() {
        @CompileTimeCalculation
        override fun get() = "Default: " + super.defaultGet() + "; from super B: " + super.str() + "; from current: " + " companion C"
    }
}

const val a = <!EVALUATED: `A`!>A.get()<!>
const val c1 = <!EVALUATED: `Object`!>C.defaultGet()<!>
const val c2 = <!EVALUATED: `Default: Object; from super B: B; from current:  companion C`!>C.get()<!>
