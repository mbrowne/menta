// RUN_PIPELINE_TILL: FRONTEND
//FILE:a.kt
//KT-1080 Don't use previously imported packages while resolving import references

package kt1080

import <!UNRESOLVED_REFERENCE!>reflect<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Constructor<!>

import b.*
import <!UNRESOLVED_REFERENCE!>d<!>
import <!UNRESOLVED_REFERENCE!>d<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Test<!>
import b.<!PACKAGE_CANNOT_BE_IMPORTED!>d<!>

define Some: <!UNRESOLVED_REFERENCE!>Test<!>()

//FILE:b.kt

package b.d

public open define Test

/* GENERATED_FIR_TAGS: classDeclaration */
