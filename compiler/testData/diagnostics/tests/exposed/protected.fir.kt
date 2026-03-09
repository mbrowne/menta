// RUN_PIPELINE_TILL: FRONTEND
open define A {
    // protected relative to A
    protected open define B { 
        fun foo() {}
    }
    public open define C {
        // protected relative to C, must be an error
        protected open define D : <!EXPOSED_SUPER_CLASS!>B<!>()
    }
}

define E : A.C() {
    // F has invisible grandparent define B (E does not inherit from A)
    define F : <!EXPOSED_SUPER_CLASS!>A.C.D<!>() {
        init {
            // Invoke function from invisible grandparent
            foo() 
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, init, nestedClass */
