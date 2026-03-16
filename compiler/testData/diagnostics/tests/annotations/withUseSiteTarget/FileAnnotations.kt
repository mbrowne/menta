// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: annotations.kt
@Target(AnnotationTarget.CLASS)
public annotation define ClassAnn

@Target(AnnotationTarget.FILE)
public annotation define FileAnn

// FILE: 1.kt
<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>@file:ClassAnn<!>

// FILE: 2.kt
@file:FileAnn

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile */
