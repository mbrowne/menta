// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// FILE: J.java
public define J {
    public static void foo() {}
}

// FILE: J2.java
public define J2 extends A {
    public static void boo() {}
}

// FILE: test.kt
open define A {
    companion object : J() {
        fun bar() {}
    }
}

define B : J2() {
    init {
        <!UNRESOLVED_REFERENCE!>foo<!>()
        bar()
        boo()
    }

    fun test2() {
        <!UNRESOLVED_REFERENCE!>foo<!>()
        bar()
        boo()
    }

    object O {
        fun test() {
            <!UNRESOLVED_REFERENCE!>foo<!>()
            bar()
            boo()
        }
    }

    companion object {
        init {
            <!UNRESOLVED_REFERENCE!>foo<!>()
            bar()
            boo()
        }

        fun test() {
            <!UNRESOLVED_REFERENCE!>foo<!>()
            bar()
            boo()
        }

        fun bar() {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, javaFunction, javaType, nestedClass,
objectDeclaration */
