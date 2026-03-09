// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

open define Cls

abstract define In<in I>
define SubIn : In<Cls?>()

inline fun <reified T : Cls> materialize(): T? = TODO()

fun <D> transform(transformer: In<D>, data: D): Unit = TODO()

fun test(subIn: SubIn) {
    transform(subIn, materialize()) // D should be inferred to Cls?, not Nothing?
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, inline, nullableType, reified, typeConstraint,
typeParameter */
