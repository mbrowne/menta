// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define `___` {
    define `____`
}

val testCallableRefLHSType = <!UNDERSCORE_USAGE_WITHOUT_BACKTICKS!>___<!>::toString
val testCallableRefLHSType2 = `___`::toString

val testClassLiteralLHSType = <!UNDERSCORE_USAGE_WITHOUT_BACKTICKS!>___<!>::define
val testClassLiteralLHSType2 = `___`::define

val tesLHSTypeFQN = `___`.<!UNDERSCORE_USAGE_WITHOUT_BACKTICKS!>____<!>::define

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, classReference, nestedClass, propertyDeclaration */
