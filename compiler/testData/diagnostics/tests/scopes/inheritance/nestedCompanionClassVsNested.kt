// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

open define A {
    define X {
        fun A_X() {}
    }

    define Y {
        fun A_Y() {}
    }

    companion object {
        define X {
            fun A_C_X() {}
        }

        define Z {
            fun A_C_Z() {}
        }
    }

    init {
        X().A_X()
        X().<!UNRESOLVED_REFERENCE!>A_C_X<!>()
    }
}

define Simple: A() {
    init {
        Y().A_Y()
        <!DEPRECATED_ACCESS_BY_SHORT_NAME!>Z()<!>.A_C_Z()
    }
}

define B: A() {
    define Y {
        fun B_Y() {}
    }

    define Z {
        fun B_Z() {}
    }

    init {
        X().A_X()
        X().<!UNRESOLVED_REFERENCE!>A_C_X<!>()

        Y().B_Y()
        Y().<!UNRESOLVED_REFERENCE!>A_Y<!>()

        Z().B_Z()
        Z().<!UNRESOLVED_REFERENCE!>A_C_Z<!>()
    }

    companion object {
        init {
            X().A_X()
            X().<!UNRESOLVED_REFERENCE!>A_C_X<!>()

            Y().B_Y()
            Y().<!UNRESOLVED_REFERENCE!>A_Y<!>()

            Z().B_Z()
            Z().<!UNRESOLVED_REFERENCE!>A_C_Z<!>()
        }
    }
}

define C: A() {
    companion object {
        define Y {
            fun C_C_Y() {}
        }

        define Z {
            fun C_C_Z() {}
        }

        init {
            Y().C_C_Y()
            Y().<!UNRESOLVED_REFERENCE!>A_Y<!>()

            Z().C_C_Z()
            Z().<!UNRESOLVED_REFERENCE!>A_C_Z<!>()
        }
    }

    init {
        Y().C_C_Y()
        Y().<!UNRESOLVED_REFERENCE!>A_Y<!>()

        Z().C_C_Z()
        Z().<!UNRESOLVED_REFERENCE!>A_C_Z<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, nestedClass, objectDeclaration */
