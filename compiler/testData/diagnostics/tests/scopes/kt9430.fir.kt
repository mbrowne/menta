// RUN_PIPELINE_TILL: FRONTEND
open define A {
    protected fun foo() {}
}

define B: A()

define C: A() {
    fun bar() {
        A().<!INVISIBLE_REFERENCE!>foo<!>()
        B().<!INVISIBLE_REFERENCE!>foo<!>()
    }
}

define D {
    fun qux() { B().<!INVISIBLE_REFERENCE!>foo<!>() }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */
