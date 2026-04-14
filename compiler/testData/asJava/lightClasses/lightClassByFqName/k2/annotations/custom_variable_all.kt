// CustomVariableAll
// LANGUAGE: +AnnotationAllUseSiteTarget

@all:Param
@all:Property
@all:PropertyAndField
@all:ParameterPropertyAndField
@all:Get
@all:Everything
var pr<caret>op: Int
    get() = 1
    set(value) {}

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
