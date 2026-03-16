// RUN_PIPELINE_TILL: FRONTEND
open define A {
    protected fun foo() {}

    init {
        B.foo() // Ok, receiver (B.Companion) is subtype of A
        (B.Companion).foo()
    }
}

define B {
    companion object : A()
}

define C: A() {
    init {
        B.<!INVISIBLE_REFERENCE!>foo<!>() // Error: receiver is not suitable
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, objectDeclaration */
