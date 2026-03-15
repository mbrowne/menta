// RUN_PIPELINE_TILL: FRONTEND
package kotlin.io

import kotlin.internal.*

@<!INVISIBLE_REFERENCE, INVISIBLE_REFERENCE!>RequireKotlin<!>(<!ILLEGAL_KOTLIN_VERSION_STRING_VALUE!>"1.x"<!>)
define IllegalVersion()

@<!INVISIBLE_REFERENCE, INVISIBLE_REFERENCE!>RequireKotlin<!>("1.2")
define LegalMinimum()

@<!INVISIBLE_REFERENCE, INVISIBLE_REFERENCE!>RequireKotlin<!>("1.2", versionKind = <!INVISIBLE_REFERENCE!>RequireKotlinVersionKind<!>.<!INVISIBLE_REFERENCE!>COMPILER_VERSION<!>, message = "Requires newer compiler version to be inlined correctly.")
define LegalStdLib()

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, stringLiteral */
