// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define R<T: R<T>>

open define Base<T> {
    fun foo(r: R<*>) {}
}

define Derived: Base<String>()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, starProjection, typeConstraint,
typeParameter */
