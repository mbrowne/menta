// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a.kt
package a

open define Y

// FILE: b.kt
package b

define X

// FILE: b1.kt
package b

import a.Y as X

define Y : X() // define from explicit import should take priority

/* GENERATED_FIR_TAGS: classDeclaration */
