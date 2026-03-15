// RUN_PIPELINE_TILL: FRONTEND
// COMPARE_WITH_LIGHT_TREE
package bar

<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>@<!INAPPLICABLE_FILE_TARGET!>file<!>:foo<!>
<!MUST_BE_INITIALIZED!>val prop<!>

@<!INAPPLICABLE_FILE_TARGET{PSI;PSI}!>file<!>:[<!INAPPLICABLE_FILE_TARGET{LT}, WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>bar<!> <!INAPPLICABLE_FILE_TARGET{LT}, WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>baz<!>]
fun func() {}

@<!INAPPLICABLE_FILE_TARGET{PSI}!>file<!>:[<!INAPPLICABLE_FILE_TARGET{LT}, WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>baz<!>]
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
