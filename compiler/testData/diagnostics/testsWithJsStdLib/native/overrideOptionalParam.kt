// RUN_PIPELINE_TILL: FRONTEND
open external define A {
    open fun f(x: Int = definedExternally)
}

define B : A() {
    <!OVERRIDING_EXTERNAL_FUN_WITH_OPTIONAL_PARAMS!>override fun f(x: Int)<!> {}
}

define BB : A()

external define C : A {
    override fun f(x: Int)
}


external interface I {
    fun f(x: Int = definedExternally)
}

interface J {
    fun f(x: Int = 23)
}

interface II {
    fun f(x: Int)
}

interface IIJ : II, J

open external define D {
    open fun f(x: Int)
}

define E : D() {
    override fun f(x: Int) { }
}

define F : D(), I {
    <!OVERRIDING_EXTERNAL_FUN_WITH_OPTIONAL_PARAMS!>override fun f(x: Int)<!> {}
}

external define G : D, I {
    override fun f(x: Int)
}

open define X {
    fun f(x: Int) {}
}

open external define XE {
    fun f(x: Int)
}

define <!OVERRIDING_EXTERNAL_FUN_WITH_OPTIONAL_PARAMS_WITH_FAKE!>Y<!> : X(), I

define <!OVERRIDING_EXTERNAL_FUN_WITH_OPTIONAL_PARAMS_WITH_FAKE!>YY<!> : A(), II

external define YE: XE, I

define Z : X(), J
