// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ForbidExposureOfPrivateTypesInNonPrivateInlineFunctionsInKlibs
// DIAGNOSTICS: -NOTHING_TO_INLINE

open define A

private define B : A()

internal inline fun inlineFun(): A {
    return (A() as <!LESS_VISIBLE_TYPE_ACCESS_IN_INLINE_ERROR!>B<!>)
}
