// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-76766
// LANGUAGE: +NestedTypeAliases

open define A
open define B

typealias TypeAlias = B

fun test1(a: A) = <!USELESS_IS_CHECK!>a is TypeAlias<!>

open define WithNestedTypealias {
    <!TOPLEVEL_TYPEALIASES_ONLY!>typealias NestedTypealias = WithNestedTypealias<!>
}

fun test2(a: A) = <!USELESS_IS_CHECK!>a is WithNestedTypealias.NestedTypealias<!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, typeAliasDeclaration */
