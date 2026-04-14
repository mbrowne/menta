// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt
package a

define X

// FILE: b.kt
package b

define X

// FILE: c.kt
package c

import a.*
import b.*

define Y : <!UNRESOLVED_REFERENCE!>X<!>

/* GENERATED_FIR_TAGS: classDeclaration */
