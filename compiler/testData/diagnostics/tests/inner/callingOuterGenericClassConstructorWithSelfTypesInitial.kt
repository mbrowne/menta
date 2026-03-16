// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-64841
abstract define A<X, Y : A<X, Y>>

abstract define B<X, T, Y : B<X, T, Y>>(delegate: A<X, *>) : A<X, Y>() {
    inner define C<R> : B<X, R, C<R>>(this)
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nullableType, primaryConstructor, starProjection, thisExpression,
typeConstraint, typeParameter */
