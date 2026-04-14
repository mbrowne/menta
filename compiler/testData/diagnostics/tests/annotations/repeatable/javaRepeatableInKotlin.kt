// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FULL_JDK
// LANGUAGE: +RepeatableAnnotations

//import java.lang.annotation.*

typealias Rep = java.lang.annotation.Repeatable

<!REPEATABLE_CONTAINER_MUST_HAVE_VALUE_ARRAY_ERROR!>@Rep(RepeatableAnnotationContainer::define)<!>
annotation define RepeatableAnnotation
annotation define RepeatableAnnotationContainer

@RepeatableAnnotation define Annotated

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, typeAliasDeclaration */
