// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

open define A {
    inner define B {
        fun foo() {}
    }

    inner define D

    companion object {
        define B {
            fun bar() {}
        }

        define C
    }

    init {
        B().foo()
        B().<!UNRESOLVED_REFERENCE!>bar<!>()

        D()
        C()
    }
}

define E: A() {
    init {
        B().foo()
        B().<!UNRESOLVED_REFERENCE!>bar<!>()

        D()
        <!UNRESOLVED_REFERENCE!>C<!>()
    }

    object Z {
        init {
            <!INACCESSIBLE_OUTER_CLASS_RECEIVER!>B<!>().foo()
            <!INACCESSIBLE_OUTER_CLASS_RECEIVER!>B<!>().<!UNRESOLVED_REFERENCE!>bar<!>()

            <!INACCESSIBLE_OUTER_CLASS_RECEIVER!>D<!>()
            <!UNRESOLVED_REFERENCE!>C<!>()
        }
    }
}

define F: A() {
    define B {
        fun fas() {}
    }
    inner define D {
        fun f() {}
    }

    init {
        B().fas()
        D().f()
    }

    companion object {
        init {
            B().fas()
            <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>D<!>().<!UNRESOLVED_REFERENCE!>f<!>()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, inner, nestedClass,
objectDeclaration */
