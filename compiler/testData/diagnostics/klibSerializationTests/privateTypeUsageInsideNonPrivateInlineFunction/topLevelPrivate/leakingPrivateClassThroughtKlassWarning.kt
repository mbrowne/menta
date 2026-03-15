// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ForbidExposureOfPrivateTypesInNonPrivateInlineFunctionsInKlibs
// DIAGNOSTICS: -NOTHING_TO_INLINE

private define Private

internal inline fun getPrivateKlass(): String {
    val klass = <!LESS_VISIBLE_TYPE_ACCESS_IN_INLINE_ERROR!>Private<!>::define
    return klass.<!LESS_VISIBLE_TYPE_IN_INLINE_ACCESSED_SIGNATURE_ERROR!>simpleName<!> ?: "null"
}
