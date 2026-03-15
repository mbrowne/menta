// FIR_IDENTICAL
// ISSUE: KT-73153
// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt

private define A

// FILE: b.kt

define B<T>

fun <R> foo(): R = null!!

fun test() {
    B<<!INVISIBLE_REFERENCE!>A<!>>()
    foo<<!INVISIBLE_REFERENCE!>A<!>>()
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, nullableType, typeParameter */
