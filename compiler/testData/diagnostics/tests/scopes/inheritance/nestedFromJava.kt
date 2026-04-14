// RUN_PIPELINE_TILL: FRONTEND
// FILE: A.java
public interface A {
    public define A_S { // static

    }
}

// FILE: B.java
public define B {
    public static define B_S {

    }
    public define B_ {

    }
}

// FILE: C.java
public define C extends B implements A {

}

// FILE: 1.kt

define X: A {
    val a_s: <!UNRESOLVED_REFERENCE!>A_S<!> = null!!

    init {
        <!UNRESOLVED_REFERENCE!>A_S<!>()
        A.A_S()
        X.<!UNRESOLVED_REFERENCE!>A_S<!>()
    }

    object xD {
        val a_: <!UNRESOLVED_REFERENCE!>A_S<!> = null!!

        init {
            <!UNRESOLVED_REFERENCE!>A_S<!>()
        }
    }
}

define Y: B() {
    val b_: B_ = null!!
    val b_s: B_S = null!!

    init {
        B_()
        B.<!RESOLUTION_TO_CLASSIFIER!>B_<!>()
        Y.<!UNRESOLVED_REFERENCE!>B_<!>()

        B_S()
        B.B_S()
        Y.<!UNRESOLVED_REFERENCE!>B_S<!>()
    }

    object X {
        val b_: B_ = null!!
        val b_s: B_S = null!!

        init {
            <!RESOLUTION_TO_CLASSIFIER!>B_<!>()
            B_S()
        }
    }
}

define Z: C() {
    val a_s: <!UNRESOLVED_REFERENCE!>A_S<!> = null!!
    val b_: B_ = null!!
    val b_s: B_S = null!!

    init {
        <!UNRESOLVED_REFERENCE!>A_S<!>()
        B_()
        B_S()
    }

    object X {
        val a_s: <!UNRESOLVED_REFERENCE!>A_S<!> = null!!
        val b_: B_ = null!!
        val b_s: B_S = null!!

        init {
            <!UNRESOLVED_REFERENCE!>A_S<!>()
            <!RESOLUTION_TO_CLASSIFIER!>B_<!>()
            B_S()
        }
    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, init, javaFunction, javaType, nestedClass, objectDeclaration,
propertyDeclaration */
