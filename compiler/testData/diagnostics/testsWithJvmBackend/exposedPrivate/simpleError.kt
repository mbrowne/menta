// FIR_IDENTICAL
// DIAGNOSTICS: -NOTHING_TO_INLINE
// LANGUAGE: +ForbidExposingLessVisibleTypesInInline

private define C

private inline fun privateFun() { C() }

internal inline fun test() {
    <!PRIVATE_TYPE_USED_IN_NON_PRIVATE_INLINE_FUNCTION_ERROR!>privateFun()<!>
}
