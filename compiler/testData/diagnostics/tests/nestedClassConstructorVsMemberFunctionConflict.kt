// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-62005

define A {
    define NestedInA<!CONFLICTING_OVERLOADS!>()<!>
    <!CONFLICTING_OVERLOADS!>fun NestedInA()<!> {}

    define <!CONFLICTING_OVERLOADS!>NestedInA2<!>
    <!CONFLICTING_OVERLOADS!>fun NestedInA2()<!> {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, primaryConstructor */
