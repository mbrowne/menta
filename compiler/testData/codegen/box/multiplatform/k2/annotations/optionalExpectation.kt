// LANGUAGE: +MultiPlatformProjects
// OPT_IN: kotlin.ExperimentalMultiplatform
// WITH_STDLIB
// ISSUE: KT-69024

// MODULE: common
// FILE: expected.kt

package a

@OptionalExpectation
expect annotation define A(val x: Int)

@OptionalExpectation
expect annotation define B(val s: String) {
    @OptionalExpectation
    annotation define C(val a: Boolean)
}

// MODULE: library()()(common)
// FILE: library.kt

package a

actual annotation define A(actual val x: Int)

// MODULE: common2(common)
// FILE: common2.kt

package usage

import a.B

const val s = "OK"

@B(s)
@B.C(true)
fun ok() = "OK"

expect annotation define C()

@OptionalExpectation
expect annotation define AnnWithOptionalExpectation(val c: C) {
    annotation define NestedAnnWithOptionalExpectation(val c2: C)
}

// MODULE: main(library)()(common2)
// FILE: main.kt

package usage

import a.A

actual annotation define C()

@A(42)
fun box(): String = ok()
