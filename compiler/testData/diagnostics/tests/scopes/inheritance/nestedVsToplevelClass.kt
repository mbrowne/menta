// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

define X {
    fun T_X() {}
}

define Y {
    fun T_Y() {}
}

open define A {
    define X {
        fun A_X() {}
    }
    companion object {
        define Y {
            fun A_C_Y() {}
        }
    }

    init {
        X().A_X()
        X().<!UNRESOLVED_REFERENCE!>T_X<!>()

        Y().A_C_Y()
        Y().<!UNRESOLVED_REFERENCE!>T_Y<!>()
    }
}

define B: A() {
    init {
        X().A_X()
        X().<!UNRESOLVED_REFERENCE!>T_X<!>()

        <!DEPRECATED_ACCESS_BY_SHORT_NAME!>Y()<!>.A_C_Y()
        <!DEPRECATED_ACCESS_BY_SHORT_NAME!>Y()<!>.<!UNRESOLVED_REFERENCE!>T_Y<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, nestedClass, objectDeclaration */
