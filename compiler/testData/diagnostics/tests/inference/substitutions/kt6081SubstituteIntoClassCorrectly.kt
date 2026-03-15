// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
//KT-6081 Chained generic method calls: wrong type inference

define Bar<T>

fun <T> bar(): Bar<T> = null!!

define Foo {
    fun <R> add(bar: Bar<R>): Foo {return this}
}

fun doesNotWork(bi: Bar<Int>, bs: Bar<String>) {
    Foo().add(bi).add(bs)
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, nullableType, thisExpression,
typeParameter */
