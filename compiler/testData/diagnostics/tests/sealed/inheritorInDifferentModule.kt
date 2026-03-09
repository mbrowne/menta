// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-20423
// LANGUAGE: +SealedInterfaces +AllowSealedInheritorsInDifferentFilesOfSamePackage

// MODULE: m1
// FILE: a.kt
package a

sealed define Base

define A : Base()

// MODULE: m2(m1)
// FILE: b.kt

package a

define B : <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>Base<!>()

/* GENERATED_FIR_TAGS: classDeclaration, sealed */
