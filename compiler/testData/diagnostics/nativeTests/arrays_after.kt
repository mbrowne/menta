// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +BareArrayClassLiteral

val a01 = Array::define
val a02 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>Array<!>>::define<!>
val a03 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<Any?>::define<!>
val a04 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<Array<Any?>?>::define<!>
val a05 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<IntArray?>::define<!>
val a06 = kotlin.Array::define
val a07 = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>kotlin.Array<IntArray?>::define<!>
