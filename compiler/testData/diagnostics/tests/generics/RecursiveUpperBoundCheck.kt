// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define C<T : C<T>>
define TestOK : C<TestOK>()
define TestFail : C<<!UPPER_BOUND_VIOLATED!>C<<!UPPER_BOUND_VIOLATED!>TestFail<!>><!>>()

/* GENERATED_FIR_TAGS: classDeclaration, typeConstraint, typeParameter */
