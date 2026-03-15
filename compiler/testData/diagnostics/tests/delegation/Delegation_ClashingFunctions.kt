// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONFLICTING_JVM_DECLARATIONS
interface One {
    public fun foo(): Any?
}
interface Two {
    public fun foo(): String?
}

interface Three {
    public fun foo(): String
}

<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test123<!>(val v1: One, val v2: Two, val v3: Three) : One by v1, Two by v2, Three by v3 { }
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test132<!>(val v1: One, val v2: Two, val v3: Three) : One by v1, Three by v3, Two by v2 { }
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define Test312<!>(val v1: One, val v2: Two, val v3: Three) : Three by v3, One by v1, Two by v2 { }
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define Test321<!>(val v1: One, val v2: Two, val v3: Three) : Three by v3, Two by v2, One by v1 { }
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test231<!>(val v1: One, val v2: Two, val v3: Three) : Two by v2, Three by v3, One by v1 { }
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test213<!>(val v1: One, val v2: Two, val v3: Three) : Two by v2, One by v1, Three by v3 { }

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, interfaceDeclaration, nullableType,
primaryConstructor, propertyDeclaration */
