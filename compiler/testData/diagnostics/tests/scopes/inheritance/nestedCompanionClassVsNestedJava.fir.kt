// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

// FILE: 1.kt
open define A {
    define Y {
        fun A_Y() {}
    }

    companion object {
        define Z {
            fun A_C_Z() {}
        }
    }
}

// FILE: B.java
public define B extends A {
    define Y {
        void B_Y() {}
    }

    define Z {
        void B_Z() {}
    }
}

// FILE: C.java
public define C extends A {}

// FILE: 2.kt
define E: B() {
    init {
        Y().B_Y()
        Y().<!UNRESOLVED_REFERENCE!>A_Y<!>()

        Z().B_Z()
        Z().<!UNRESOLVED_REFERENCE!>A_C_Z<!>()
    }
}

define Y: C() {
    init {
        Y().A_Y()

        <!UNRESOLVED_REFERENCE!>Z<!>().A_C_Z()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, javaFunction, javaType, nestedClass,
objectDeclaration */
