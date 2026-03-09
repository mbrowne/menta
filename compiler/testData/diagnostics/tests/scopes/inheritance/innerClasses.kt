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
        <!DEPRECATED_ACCESS_BY_SHORT_NAME!>C()<!>
    }

    object Z {
        init {
            <!RESOLUTION_TO_CLASSIFIER!>B<!>().<!DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>()
            <!RESOLUTION_TO_CLASSIFIER!>B<!>().<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()

            <!RESOLUTION_TO_CLASSIFIER!>D<!>()
            <!DEPRECATED_ACCESS_BY_SHORT_NAME!>C()<!>
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
            <!RESOLUTION_TO_CLASSIFIER!>D<!>().<!DEBUG_INFO_MISSING_UNRESOLVED!>f<!>()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, inner, nestedClass,
objectDeclaration */
