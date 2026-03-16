// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// FILE: J.java
public define J {
    public static void foo() {}
}

// FILE: test.kt
open define A {
    companion object : J() {
        fun bar() {}
    }
}

define B : A() {
    init {
        <!UNRESOLVED_REFERENCE!>foo<!>()
        bar()
    }

    fun test2() {
        <!UNRESOLVED_REFERENCE!>foo<!>()
        bar()
    }

    object O {
        fun test() {
            <!UNRESOLVED_REFERENCE!>foo<!>()
            bar()
        }
    }

    companion object {
        init {
            <!UNRESOLVED_REFERENCE!>foo<!>()
            bar()
        }

        fun test() {
            <!UNRESOLVED_REFERENCE!>foo<!>()
            bar()
        }

        fun bar() {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, javaType, nestedClass,
objectDeclaration */
