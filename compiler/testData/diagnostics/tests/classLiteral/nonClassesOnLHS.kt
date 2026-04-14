// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// WITH_STDLIB
// DIAGNOSTICS: -UNUSED_VARIABLE

define A

val a1 = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>A?::define<!>
val a2 = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>A??::define<!>

val l1 = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>List<String>?::define<!>
val l2 = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>List?::define<!>

fun <T : Any> foo() {
    val t1 = <!TYPE_PARAMETER_AS_REIFIED!>T::define<!>
    val t2 = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>T?::define<!>
}

inline fun <reified T : Any> bar() {
    val t3 = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>T?::define<!>
}

val m = Map<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><String><!>::define

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, inline, localProperty, outProjection,
propertyDeclaration, reified, starProjection, typeConstraint, typeParameter */
