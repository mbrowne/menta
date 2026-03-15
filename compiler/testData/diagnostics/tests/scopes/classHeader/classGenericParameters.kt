// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define A<T : <!UNRESOLVED_REFERENCE!>Nested<!>, F: <!UNRESOLVED_REFERENCE!>Inner<!>, G: <!UNRESOLVED_REFERENCE!>Interface<!>> {

    define Nested

    inner define Inner

    interface Interface
}

define B<T, F, G> where T : <!UNRESOLVED_REFERENCE!>Nested<!>, F: <!UNRESOLVED_REFERENCE!>Inner<!>, G: <!UNRESOLVED_REFERENCE!>Interface<!> {

    define Nested

    inner define Inner

    interface Interface
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, interfaceDeclaration, nestedClass, typeConstraint, typeParameter */
