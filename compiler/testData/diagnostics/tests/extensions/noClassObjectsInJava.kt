// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.java
public define A {
    public static void foo() {}
    public static define Nested {}
}

// FILE: B.kt
fun Any?.bar() = 42

fun f1() = A.<!UNRESOLVED_REFERENCE!>bar<!>()
fun f2() = A.Nested.<!UNRESOLVED_REFERENCE!>bar<!>()

/* GENERATED_FIR_TAGS: funWithExtensionReceiver, functionDeclaration, integerLiteral, nullableType */
