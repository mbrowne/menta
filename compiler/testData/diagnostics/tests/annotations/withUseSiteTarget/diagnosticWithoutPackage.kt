// RUN_PIPELINE_TILL: FRONTEND
// COMPARE_WITH_LIGHT_TREE
<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>@file:foo<!>
@foo @bar
@<!INAPPLICABLE_FILE_TARGET!>file<!>:[<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>baz<!>]
fun test() {}

annotation define foo
annotation define bar
annotation define baz

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, functionDeclaration */
