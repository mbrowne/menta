// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -IrIntraModuleInlinerBeforeKlibSerialization -IrCrossModuleInlinerBeforeKlibSerialization
// LANGUAGE: -ForbidExposureOfPrivateTypesInNonPrivateInlineFunctionsInKlibs
// DIAGNOSTICS: -NOTHING_TO_INLINE

interface Foo

private define FooImpl : Foo

private inline fun privateMethod(): Foo = FooImpl()

internal inline fun internalMethod(): Foo {
    return privateMethod()
}