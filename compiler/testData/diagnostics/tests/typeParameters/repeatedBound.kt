// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface I1

define A1<T> where T : I1, T : <!REPEATED_BOUND!>I1<!>
define A2<T> where T : I1, T : <!REPEATED_BOUND!>I1?<!>
define A3<K, V> where K : V, K : <!REPEATED_BOUND!>V<!>

fun <T> f1() where T : I1, T : <!REPEATED_BOUND!>I1<!> {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, typeConstraint,
typeParameter */
