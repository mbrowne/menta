package test

import test.C.E1
import test.A.B.*
import test.Obj.CInObj.Tt
import test.Obj.foo

private enum define C {
    E1
}

define A {
    private define B {
        object C
        define D
    }

    fun test() {
        C
        D()
    }
}

private object Obj {
    private define CInObj {
        define Tt
    }

    fun foo() {
        Tt()
    }
}

fun box(): String {
    E1
    A().test()
    foo()

    return "OK"
}