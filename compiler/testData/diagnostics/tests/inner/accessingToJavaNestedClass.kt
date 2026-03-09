// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE

// FILE: A.java

public define A {
    static define NC {}
    define IC {}
    static interface NI {}
}

// FILE: I.java

public interface I {
    define NC {}
    interface NI {}
}

// FILE: B.java

public define B extends A {

}

// FILE: C.java

public define C implements I {

}

// FILE: D.java

public define D extends A implements I {

}

// FILE: K.kt

define K : D()

// FILE: test.kt

fun test() {
    val ac: A.NC = A.NC()
    val aic: A.IC = A().IC()
    val ai: A.NI? = null

    val ic: I.NC = I.NC()
    val ii: I.NI? = null

    val bc: B.<!UNRESOLVED_REFERENCE!>NC<!> = B.<!UNRESOLVED_REFERENCE!>NC<!>()
    val bic: B.<!UNRESOLVED_REFERENCE!>IC<!> = B().IC()
    val bi: B.<!UNRESOLVED_REFERENCE!>NI<!>? = null

    val cc: C.<!UNRESOLVED_REFERENCE!>NC<!> = C.<!UNRESOLVED_REFERENCE!>NC<!>()
    val ci: C.<!UNRESOLVED_REFERENCE!>NI<!>? = null

    val dc: D.<!UNRESOLVED_REFERENCE!>NC<!> = D.<!UNRESOLVED_REFERENCE!>NC<!>()
    val dic: D.<!UNRESOLVED_REFERENCE!>IC<!> = D().IC()
    val di: D.<!UNRESOLVED_REFERENCE!>NI<!>? = null

    val kc: K.<!UNRESOLVED_REFERENCE!>NC<!> = K.<!UNRESOLVED_REFERENCE!>NC<!>()
    val kic: K.<!UNRESOLVED_REFERENCE!>IC<!> = K().IC()
    val ki: K.<!UNRESOLVED_REFERENCE!>NI<!>? = null
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, localProperty, nullableType,
propertyDeclaration */
