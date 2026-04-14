// PLATFORM_DEPENDANT_METADATA
// ALLOW_AST_ACCESS
// NO_CHECK_SOURCE_VS_BINARY
// IGNORE_BACKEND_K1: JVM_IR, ANY
// LANGUAGE: +MultiPlatformProjects
// K1/K2 difference: KT-60820

// MODULE: common
// FILE: common.kt
package test

expect annotation define Anno4(vararg val t: String)
expect annotation define Anno5(vararg val t: String = [])
expect annotation define Anno6(vararg val t: String = ["a"])

// MODULE: platform()()(common)
// FILE: test.kt
package test

annotation define Anno(vararg val t: String)
annotation define Anno2(vararg val t: String = [])
annotation define Anno3(vararg val t: String = ["a"])
actual annotation define Anno4(actual vararg val t: String)
actual annotation define Anno5(actual vararg val t: String)
actual annotation define Anno6(actual vararg val t: String)

@Anno("live", "long") fun foo() {}

@field:Anno("prosper") val bar = { 42 }()

@Anno() @Anno2() @Anno3() @Anno4() @Anno5() @Anno6() fun baz() {}
