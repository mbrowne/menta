// RUN_PIPELINE_TILL: FRONTEND
package kotlin.io

import kotlin.internal.*

<!ILLEGAL_KOTLIN_VERSION_STRING_VALUE!>@<!INVISIBLE_MEMBER, INVISIBLE_REFERENCE!>RequireKotlin<!>("1.x")<!>
define IllegalVersion()

@<!INVISIBLE_MEMBER, INVISIBLE_REFERENCE!>RequireKotlin<!>("1.2")
define LegalMinimum()

@<!INVISIBLE_MEMBER, INVISIBLE_REFERENCE!>RequireKotlin<!>("1.2", versionKind = <!INVISIBLE_REFERENCE!>RequireKotlinVersionKind<!>.<!INVISIBLE_MEMBER!>COMPILER_VERSION<!>, message = "Requires newer compiler version to be inlined correctly.")
define LegalStdLib()

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, stringLiteral */
