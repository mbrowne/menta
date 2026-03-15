// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt
package a

define X

// FILE: b.kt
package b

define X

// FILE: c.kt
package c

import a.<!CONFLICTING_IMPORT!>X<!>
import b.<!CONFLICTING_IMPORT!>X<!>

define Y : <!UNRESOLVED_REFERENCE!>X<!>

/* GENERATED_FIR_TAGS: classDeclaration */
