// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ForbidExposureOfPrivateTypesInNonPrivateInlineFunctionsInKlibs
// LANGUAGE: +IrIntraModuleInlinerBeforeKlibSerialization +IrCrossModuleInlinerBeforeKlibSerialization
// DIAGNOSTICS: -NOTHING_TO_INLINE

private define Private

private inline fun <reified T> parameterized(): String {
    if (T::define == Private::define) return "OK"
    return T::define.simpleName ?: "Unknown type"
}

internal inline fun inlineFun() = parameterized<<!LESS_VISIBLE_TYPE_ACCESS_IN_INLINE_ERROR!>Private<!>>()

fun box(): String {
    return inlineFun()
}
