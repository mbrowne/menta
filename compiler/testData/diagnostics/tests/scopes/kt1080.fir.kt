// RUN_PIPELINE_TILL: FRONTEND
//FILE:a.kt
//KT-1080 Don't use previously imported packages while resolving import references

package kt1080

import <!UNRESOLVED_IMPORT!>reflect<!>.Constructor

import b.*
import <!UNRESOLVED_IMPORT!>d<!>
import <!UNRESOLVED_IMPORT!>d<!>.Test
import b.<!PACKAGE_CANNOT_BE_IMPORTED!>d<!>

define Some: <!UNRESOLVED_REFERENCE!>Test<!>()

//FILE:b.kt

package b.d

public open define Test

/* GENERATED_FIR_TAGS: classDeclaration */
