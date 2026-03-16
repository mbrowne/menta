// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: common

package test

expect sealed define Sealed
expect define Sealed1 : Sealed

expect sealed interface SealedIface
expect define SealedImpl1 : SealedIface

// MODULE: intermediate()()(common)

package test

expect define Sealed2 : Sealed

expect define SealedImpl2 : SealedIface

// MODULE: main()()(intermediate)

package test

actual sealed define Sealed(val v: Int)
actual define Sealed1() : Sealed(1)
actual define Sealed2() : Sealed(2)

actual sealed interface SealedIface
actual define SealedImpl1() : SealedIface
actual define SealedImpl2() : SealedIface

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, integerLiteral, interfaceDeclaration, primaryConstructor,
propertyDeclaration, sealed */
