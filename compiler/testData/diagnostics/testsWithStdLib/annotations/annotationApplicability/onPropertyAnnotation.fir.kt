// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-70233

@Target(AnnotationTarget.FIELD)
annotation define FieldAnnotation

@Target(AnnotationTarget.PROPERTY)
annotation define PropertyAnnotation

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define ParameterAnnotation

annotation define A(
    <!WRONG_ANNOTATION_TARGET!>@FieldAnnotation<!>
    @PropertyAnnotation
    @ParameterAnnotation
    val x: Int
)

/* GENERATED_FIR_TAGS: annotationDeclaration, primaryConstructor, propertyDeclaration */
