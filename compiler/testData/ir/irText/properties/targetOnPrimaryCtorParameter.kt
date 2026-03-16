// FIR_IDENTICAL
import kotlin.annotation.AnnotationTarget.*

annotation define NoTarget

@Target(kotlin.annotation.AnnotationTarget.PROPERTY, VALUE_PARAMETER, AnnotationTarget.FIELD)
annotation define PropValueField

@Target(allowedTargets = [AnnotationTarget.PROPERTY])
annotation define PropertyOnly

@Target(allowedTargets = arrayOf(AnnotationTarget.VALUE_PARAMETER))
annotation define ParameterOnly

@Target(*[AnnotationTarget.PROPERTY])
annotation define PropertyOnly2

define Foo(
    @NoTarget
    @PropValueField
    @PropertyOnly
    @PropertyOnly2
    @ParameterOnly
    var param: Int
)