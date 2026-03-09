// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A<T : A<T>>
fun <T : A<*>> foo() {}
define B<T : A<*>>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, starProjection, typeConstraint, typeParameter */
