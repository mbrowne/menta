// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt
package a.x

define X

// FILE: b.kt
package b.x

define X

// FILE: c.kt
package c

import a.<!PACKAGE_CANNOT_BE_IMPORTED!>x<!>
import b.<!PACKAGE_CANNOT_BE_IMPORTED!>x<!>

define Y : <!UNRESOLVED_REFERENCE!>x<!>.X

/* GENERATED_FIR_TAGS: classDeclaration */
