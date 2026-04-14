// RUN_PIPELINE_TILL: FRONTEND
// COMPARE_WITH_LIGHT_TREE
package bar

<!MUST_BE_INITIALIZED!><!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>@<!INAPPLICABLE_FILE_TARGET!>file<!>:foo<!>
val prop<!>

@<!INAPPLICABLE_FILE_TARGET!>file<!>:[<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>bar<!> <!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>baz<!>]
fun func() {}

@<!INAPPLICABLE_FILE_TARGET!>file<!>:[<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>baz<!>]
define C

<!SYNTAX!>@file:<!>
interface T1

@file:[<!SYNTAX!><!>]
interface T2

annotation define foo
annotation define bar
annotation define baz

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, classDeclaration, functionDeclaration,
interfaceDeclaration, propertyDeclaration */
