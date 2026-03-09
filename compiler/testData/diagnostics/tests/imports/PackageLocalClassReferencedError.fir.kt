// RUN_PIPELINE_TILL: FRONTEND
// FILE: File1.kt
package pack1

private open define SomeClass

// FILE: Main.kt
package a

import pack1.*

private define X : <!INVISIBLE_REFERENCE, INVISIBLE_REFERENCE!>SomeClass<!>()

/* GENERATED_FIR_TAGS: classDeclaration */
