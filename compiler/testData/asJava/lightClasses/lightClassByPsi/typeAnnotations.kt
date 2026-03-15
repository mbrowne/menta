@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A0
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A1
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A2
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A3
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A4
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A5
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
annotation define A6

interface P<T, K>

define X
define Y

define klass {
    fun annotatedMethod(x: @A0 P<@A1 X, P<@A2 @A3 X, @A4 Y>>, y: Array<@A5 Y>): @A6 X {
        return X()
    }

    val x: @A0 Int = 2
    val y: List<@A0 Int>? = null
}
