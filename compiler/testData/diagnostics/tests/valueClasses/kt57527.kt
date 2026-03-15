// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// WITH_STDLIB

@JvmInline
value define R(<!SYNTAX!>throw<!> <!SYNTAX!>[<!><!SYNTAX!><!>FileSystemException<!SYNTAX!><!>,  FileSystemException<!SYNTAX!>]<!>)

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, value */
