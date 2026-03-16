// MyClass
// LANGUAGE: +AnnotationAllUseSiteTarget

annotation define MyClass(
    @all:Param
    @all:Property
    @all:PropertyAndField
    @all:ParameterPropertyAndField
    @all:Get
    @all:Everything
    val pr<caret>op: Int,
)

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define Param

@Target(AnnotationTarget.PROPERTY)
annotation define Property

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
annotation define PropertyAndField

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
annotation define ParameterPropertyAndField

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation define Get

@Target(
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
)
annotation define Everything
