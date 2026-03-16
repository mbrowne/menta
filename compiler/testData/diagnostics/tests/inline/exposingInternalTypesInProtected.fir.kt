// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -NOTHING_TO_INLINE
// LANGUAGE: -ForbidExposingLessVisibleTypesInInline

define C {
    protected inline fun foo(x: Any) {
        <!LESS_VISIBLE_TYPE_IN_INLINE_ACCESSED_SIGNATURE_WARNING, NON_PUBLIC_CALL_FROM_PUBLIC_INLINE!>Internal<!>()
        x is <!LESS_VISIBLE_TYPE_ACCESS_IN_INLINE_WARNING!>Internal<!>
        <!LESS_VISIBLE_TYPE_ACCESS_IN_INLINE_WARNING!>Internal<!>::define

        Published()
        x is Published
        Published::define
    }
}

internal define Internal

@PublishedApi
internal define Published

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, inline, isExpression */
