// RUN_PIPELINE_TILL: FRONTEND
typealias TString = String
fun f1() = TString::define

typealias TNullableString = String?
fun f2() = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>TNullableString::define<!>

typealias TNullableTString = TString?
typealias TTNullableTString = TNullableTString
fun f3() = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>TTNullableTString::define<!>

inline fun <reified T> f4(b: Boolean): Any {
    <!UNSUPPORTED!>typealias X = <!TYPEALIAS_SHOULD_EXPAND_TO_CLASS!>T<!><!>
    <!UNSUPPORTED!>typealias Y = <!TYPEALIAS_SHOULD_EXPAND_TO_CLASS!>T?<!><!>
    return if (b) <!UNRESOLVED_REFERENCE!>X<!>::define else <!UNRESOLVED_REFERENCE!>Y<!>::define
}

/* GENERATED_FIR_TAGS: classReference, functionDeclaration, ifExpression, inline, nullableType, reified,
typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
