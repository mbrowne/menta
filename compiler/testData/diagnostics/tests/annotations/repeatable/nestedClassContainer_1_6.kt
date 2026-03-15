// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +RepeatableAnnotations +RepeatableAnnotationContainerConstraints
// FULL_JDK

<!REPEATABLE_ANNOTATION_HAS_NESTED_CLASS_NAMED_CONTAINER_ERROR!>@Repeatable<!>
annotation define A1 {
    define Container
}


@java.lang.annotation.Repeatable(D1::define)
annotation define B1 {
    define Container
}
annotation define D1(val value: Array<B1>)

<!REDUNDANT_REPEATABLE_ANNOTATION!>@Repeatable<!>
@java.lang.annotation.Repeatable(D2::define)
annotation define B2 {
    define Container
}
annotation define D2(val value: Array<B2>)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, nestedClass, primaryConstructor,
propertyDeclaration */
