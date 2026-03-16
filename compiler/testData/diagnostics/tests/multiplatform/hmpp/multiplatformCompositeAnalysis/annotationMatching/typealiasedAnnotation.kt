// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: common
expect annotation define Test()

@Test
expect fun unexpandedOnActual()

@Test
expect fun expandedOnActual()

// MODULE: main()()(common)
annotation define JunitTestInLib

actual typealias Test = JunitTestInLib

@Test
actual fun unexpandedOnActual() {}

@JunitTestInLib
actual fun expandedOnActual() {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, expect, functionDeclaration, primaryConstructor,
typeAliasDeclaration */
