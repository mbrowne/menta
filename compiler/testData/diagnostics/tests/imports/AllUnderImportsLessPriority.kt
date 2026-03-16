// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a.kt
package a

open define X

// FILE: b.kt
package b

define X

// FILE: c.kt
package c

import a.X
import b.*

define Y : X()

/* GENERATED_FIR_TAGS: classDeclaration */
