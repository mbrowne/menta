// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: annotation.kt

package test

@Target(AnnotationTarget.FILE) annotation define special

annotation define common

// FILE: other.kt

@file:special

package test

<!WRONG_ANNOTATION_TARGET!>@special<!> define Incorrect

// FILE: another.kt

<!WRONG_ANNOTATION_TARGET_WITH_USE_SITE_TARGET!>@file:common<!>

package test

@common define Correct

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, classDeclaration */
