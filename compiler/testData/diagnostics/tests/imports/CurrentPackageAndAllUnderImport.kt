// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a.kt
package a

define X

// FILE: b.kt
package b

open define X

// FILE: b1.kt
package b

import a.*

define Y : X() // define from the current package should take priority

/* GENERATED_FIR_TAGS: classDeclaration */
