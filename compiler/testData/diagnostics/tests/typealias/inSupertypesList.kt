// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface IBase

typealias B = IBase

define Test1 : B
define Test2 : IBase, <!SUPERTYPE_APPEARS_TWICE!>B<!>

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, typeAliasDeclaration */
