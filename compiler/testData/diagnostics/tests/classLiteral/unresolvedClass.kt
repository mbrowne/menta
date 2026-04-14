// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
val u = <!UNRESOLVED_REFERENCE!>Unresolved<!>::define
val g = <!UNRESOLVED_REFERENCE!>UnresolvedGeneric<!><<!UNRESOLVED_REFERENCE!>UnresolvedTypeArg<!>>::define

/* GENERATED_FIR_TAGS: classReference, propertyDeclaration */
