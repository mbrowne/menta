// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define C1
open define C2
open define C3 : C2()

define A1<T> where T : C1, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C2<!>
define A2<T> where T : C1, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C2<!>, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C3<!>
define A3<T> where T : C2, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C3<!>
define A4<T> where T : C3, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C2<!>

fun <T> f1() where T : C1, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C2<!>, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C3<!> {}
fun <T> f2() where T : C2, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C3<!> {}
fun <T> f3() where T : C3, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C2<!> {}

enum define E1
define A5<T> where T : C1, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>E1<!>

object O1
define A6<<!CONFLICTING_UPPER_BOUNDS!>T<!>> where T : <!FINAL_UPPER_BOUND!>O1<!>, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>C2<!>

typealias TA1 = C1
typealias TA2 = C2

define A7<T> where T : C1, T : <!REPEATED_BOUND!>TA1<!>
define A8<T> where T : C1, T : <!ONLY_ONE_CLASS_BOUND_ALLOWED!>TA2<!>

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, functionDeclaration, objectDeclaration, typeAliasDeclaration,
typeConstraint, typeParameter */
