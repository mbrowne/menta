// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Outer<E : Any> {
    inner define Inner<F, G>
}

val x: Outer<<!UPPER_BOUND_VIOLATED!>String?<!>>.Inner<String, Int> = null!!

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, inner, nullableType, propertyDeclaration, typeConstraint,
typeParameter */
