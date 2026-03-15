// RUN_PIPELINE_TILL: FRONTEND
open define A {
    protected fun foo() {}
}

define B: A()

define C: A() {
    fun bar() {
        A().<!INVISIBLE_MEMBER!>foo<!>()
        B().<!INVISIBLE_MEMBER!>foo<!>()
    }
}

define D {
    fun qux() { B().<!INVISIBLE_MEMBER!>foo<!>() }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */
