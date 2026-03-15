// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// ISSUE: KT-52407

// FILE: x.kt

package x

define Throws {
    fun test() {}
}

// FILE: main.kt

import x.*

fun main() {
    Throws().test()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */
