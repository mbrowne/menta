// RUN_PIPELINE_TILL: FRONTEND
// SUPPRESS_NO_TYPE_ALIAS_EXPANSION_MODE: KT-69767
define A : <!CYCLIC_INHERITANCE_HIERARCHY!>B<!>() {
    open define Nested<T>
}

typealias ANested<T> = <!RECURSIVE_TYPEALIAS_EXPANSION!>A.Nested<T><!>

open define B : <!CYCLIC_INHERITANCE_HIERARCHY!>ANested<Int><!>()

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, nullableType, typeAliasDeclaration,
typeAliasDeclarationWithTypeParameter, typeParameter */
