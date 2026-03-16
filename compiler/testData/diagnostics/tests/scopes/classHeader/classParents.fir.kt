// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

interface I<F, G, H>

define A(impl: Interface) : <!UNRESOLVED_REFERENCE!>Nested<!>(), <!UNRESOLVED_REFERENCE, UNRESOLVED_REFERENCE!>Interface<!> by impl, <!UNRESOLVED_REFERENCE!>Inner<!>, I<<!UNRESOLVED_REFERENCE!>Nested<!>, <!UNRESOLVED_REFERENCE!>Interface<!>, <!UNRESOLVED_REFERENCE!>Inner<!>> {

    define Nested

    inner define Inner

    interface Interface
}

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, inner, interfaceDeclaration, nestedClass, nullableType,
primaryConstructor, typeParameter */
