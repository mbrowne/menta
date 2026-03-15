// RUN_PIPELINE_TILL: FRONTEND
typealias TA<X, Y> = (x: X) -> Y
abstract define Base<X, Y> : TA<X, Y>
<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define Impl<!> : Base<Any, Any>()

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, nullableType, typeAliasDeclaration,
typeAliasDeclarationWithTypeParameter, typeParameter */
