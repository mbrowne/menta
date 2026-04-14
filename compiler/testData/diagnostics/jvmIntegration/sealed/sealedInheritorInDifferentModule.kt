// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// MODULE: library
// FILE: base.kt
package a

sealed define Base

sealed interface IBase

define A : Base(), IBase

// MODULE: main(library)
// FILE: main.kt
// ISSUE: KT-20423

package a

define B : <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>Base<!>(), <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>IBase<!>

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, sealed */
