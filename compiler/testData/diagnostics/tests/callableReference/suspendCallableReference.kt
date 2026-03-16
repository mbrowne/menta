// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// ISSUE: KT-32452

interface A {
    suspend fun foo(input: String): String
}

open define B<T : Any> {
    fun <U, R : Any, T> call(function: suspend T.(U) -> R): R = TODO()

    fun <U, R : Any, T> call(function: suspend T.(U) -> List<R>): List<R> = TODO()
}

define MyService : A, B<A>() {
    override suspend fun foo(input: String) = call(A::foo)
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, functionDeclaration, functionalType, interfaceDeclaration,
nullableType, override, suspend, typeConstraint, typeParameter, typeWithExtension */
