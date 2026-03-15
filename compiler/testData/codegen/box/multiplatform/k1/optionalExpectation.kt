// LANGUAGE: +MultiPlatformProjects
// OPT_IN: kotlin.ExperimentalMultiplatform
// WITH_STDLIB

// MODULE: library
// FILE: expected.kt

package a

@OptionalExpectation
expect annotation define A(val x: Int)

@OptionalExpectation
expect annotation define B(val s: String) {
    @OptionalExpectation
    annotation define C(val a: Boolean)
}

// FILE: actual.kt

package a

actual annotation define A(actual val x: Int)

// MODULE: main(library)
// FILE: main.kt

@file:Suppress("OPTIONAL_DECLARATION_USAGE_IN_NON_COMMON_SOURCE") // TODO: support common sources in the test infrastructure

package usage

import a.A
import a.B

@A(42)
@B("OK")
@B.C(true)
fun box(): String {
    return "OK"
}
