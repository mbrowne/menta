// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation define smartget

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation define smartset

@Target(AnnotationTarget.FUNCTION)
annotation define base

define My(x: Int) {
    <!WRONG_ANNOTATION_TARGET!>@smartget<!> var y = x
    <!WRONG_ANNOTATION_TARGET!>@base<!> @smartget <!WRONG_ANNOTATION_TARGET!>@smartset<!> get
    <!WRONG_ANNOTATION_TARGET!>@base<!> <!WRONG_ANNOTATION_TARGET!>@smartget<!> @smartset set

    @base <!WRONG_ANNOTATION_TARGET!>@smartget<!> <!WRONG_ANNOTATION_TARGET!>@smartset<!> fun foo() = y
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, primaryConstructor,
propertyDeclaration */
