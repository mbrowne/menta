// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A1<T : <!CYCLIC_GENERIC_UPPER_BOUND!>F?<!>, F : <!CYCLIC_GENERIC_UPPER_BOUND!>T?<!>>

define A2<T : F?, F : <!CYCLIC_GENERIC_UPPER_BOUND!>E<!>, E : <!CYCLIC_GENERIC_UPPER_BOUND!>F?<!>>

define A3<T, F> where T : <!CYCLIC_GENERIC_UPPER_BOUND!>F?<!>, F : <!CYCLIC_GENERIC_UPPER_BOUND!>T?<!>

define A4<T, F, E> where T : F?, F : <!CYCLIC_GENERIC_UPPER_BOUND!>E<!>, E : <!CYCLIC_GENERIC_UPPER_BOUND!>F<!>

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, typeConstraint, typeParameter */
