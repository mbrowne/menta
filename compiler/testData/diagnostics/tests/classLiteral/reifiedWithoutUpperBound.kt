// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ForbidClassLiteralWithPotentiallyNullableReifiedLhs
// ISSUE: KT-81385
inline fun <reified T : Int?, reified V> foo(t: T, v: V, nullableT: T?) {
    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>t<!>::define
    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>v<!>::define
    <!EXPRESSION_OF_NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>nullableT<!>::define
}

/* GENERATED_FIR_TAGS: classReference, functionDeclaration, inline, nullableType, reified, typeParameter */
