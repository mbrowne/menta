// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@Target(AnnotationTarget.CLASS)
annotation define base

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation define meta

@base define Outer {
    @base <!WRONG_ANNOTATION_TARGET!>@meta<!> define Nested

    @base @meta annotation define Annotated

    fun foo() {
        @base <!WRONG_ANNOTATION_TARGET!>@meta<!> define Local
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, localClass, nestedClass */
