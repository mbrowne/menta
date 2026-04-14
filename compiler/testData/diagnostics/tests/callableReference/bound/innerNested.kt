// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Outer {
    define Nested
    inner define Inner
}

fun test() {
    Outer()::Inner
    Outer()::<!UNRESOLVED_REFERENCE!>Nested<!>
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, functionDeclaration, inner, nestedClass */
