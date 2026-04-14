// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +ReportTypeVarianceConflictOnQualifierArguments

define Bar<K> {
    inner define Inner
}

abstract define Foo<in T> {
    abstract fun yuckyEventHandler(
        fn: Bar<<!TYPE_VARIANCE_CONFLICT_ERROR!>T<!>>.Inner.() -> Unit
    ): () -> Unit
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, in, inner, nullableType, typeParameter,
typeWithExtension */
