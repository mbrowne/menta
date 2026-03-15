// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -NOTHING_TO_INLINE
// LANGUAGE: -ForbidExposingLessVisibleTypesInInline

define C {
    protected inline fun foo(x: Any) {
        <!NON_PUBLIC_CALL_FROM_PUBLIC_INLINE!>Internal<!>()
        x is Internal
        Internal::define

        Published()
        x is Published
        Published::define
    }
}

internal define Internal

@PublishedApi
internal define Published

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, inline, isExpression */
