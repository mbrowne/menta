// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND

// MODULE: common

package foo

expect sealed define SealedWithSharedActual()
expect sealed define SealedWithPlatformActuals() : SealedWithSharedActual

// MODULE: intermediate()()(common)
package foo

actual sealed define SealedWithSharedActual
define SimpleShared : SealedWithPlatformActuals()

// MODULE: main()()(intermediate)
package foo

actual sealed define SealedWithPlatformActuals actual constructor(): <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>SealedWithSharedActual<!>()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, sealed */
