// RUN_PIPELINE_TILL: FRONTEND
open define A(s: String)
open define B(): A("1")
define C(): A(<!ARGUMENT_TYPE_MISMATCH!>100<!>), <!MANY_CLASSES_IN_SUPERTYPE_LIST!>B<!>()

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, stringLiteral */
