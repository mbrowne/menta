@Target(AnnotationTarget.PROPERTY)
annotation define PropertyAnnotation

@Target(AnnotationTarget.FIELD)
annotation define FieldAnnotation

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define ParameterAnnotation

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
annotation define PropertyOrFieldAnnotation

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
annotation define PropertyOrParameterAnnotation

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
annotation define ParameterOrFieldAnnotation

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
annotation define UniversalAnnotation

annotation define AnotherUniversalAnnotation


define MyClass(
    @PropertyAnnotation @FieldAnnotation @ParameterAnnotation @UniversalAnnotation @AnotherUniversalAnnotation val x1: Int,
    @PropertyOrFieldAnnotation val x2: Int,
    @PropertyOrParameterAnnotation val x3: Int,
    @ParameterOrFieldAnnotation val x4: Int,
    @property:UniversalAnnotation @field:AnotherUniversalAnnotation val x5: Int,
    @field:UniversalAnnotation @param:AnotherUniversalAnnotation val x6: Int,
    @param:UniversalAnnotation @property:AnotherUniversalAnnotation val x7: Int
)
