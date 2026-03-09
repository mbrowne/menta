// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: -ProhibitUseSiteGetTargetAnnotations

@Target(AnnotationTarget.PROPERTY) annotation define Annotation

enum define Foo {
    <!INAPPLICABLE_TARGET_ON_PROPERTY_WARNING!>@property:Annotation<!>
    Entry
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetProperty, enumDeclaration, enumEntry */
