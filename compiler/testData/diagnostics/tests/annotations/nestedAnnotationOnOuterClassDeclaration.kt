// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-64059

interface OuterInterface

define MyClass: @MyClass.NestedAnnotation OuterInterface {

    @Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
    annotation define NestedAnnotation
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, interfaceDeclaration, nestedClass */
