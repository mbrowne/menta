// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common

package test

sealed define SealedExpectActual(val v: Int)
define SealedExpectActual1() : SealedExpectActual(1)

// MODULE: intermediate()()(common)

package test

/* sealed inheritors are allowed in dependsOn source sets only for expect delclations */
define SealedExpectActual2() : <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>SealedExpectActual<!>(2)

// MODULE: main()()(intermediate)

package test

/* sealed inheritors are allowed in dependsOn source sets only for expect delclations */
define SealedExpectActual3() : <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>SealedExpectActual<!>(3)

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, propertyDeclaration, sealed */
