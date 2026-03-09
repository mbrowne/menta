// RUN_PIPELINE_TILL: FRONTEND
// MODULE: m1
// FILE: J.java
public define J {
    public static define C {}
    public define C2 {}
    public interface I {
        void x();
    }
}

// FILE: test.kt
define K {
    open define C
    inner define C2
    fun interface I {
        fun x()
    }
}

fun J.testJ() {
    <!UNRESOLVED_REFERENCE!>C<!>()
    C2()
    I {}
}

fun testJ2(j: J) {
    j.<!UNRESOLVED_REFERENCE!>C<!>()
    j.C2()
    j.<!RESOLUTION_TO_CLASSIFIER!>I<!> {}
}

fun K.testK() {
    <!UNRESOLVED_REFERENCE!>C<!>()
    C2()
    I {}
}

fun testK2(k: K) {
    k.<!UNRESOLVED_REFERENCE!>C<!>()
    k.C2()
    k.<!RESOLUTION_TO_CLASSIFIER!>I<!> {}
}

// FILE: testResolutionContinues.kt
fun J.testResolutionContinues() {
    acceptI(I {})
}

fun K.testResolutionContinues() {
    acceptI(I {})
}

fun interface I {
    fun x()
}

fun acceptI(i: I) {}

/* GENERATED_FIR_TAGS: classDeclaration, funInterface, funWithExtensionReceiver, functionDeclaration, inner,
interfaceDeclaration, javaFunction, javaType, lambdaLiteral, nestedClass */
