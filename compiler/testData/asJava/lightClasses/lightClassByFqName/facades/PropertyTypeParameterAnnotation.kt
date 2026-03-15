// one.PropertyTypeParameterAnnotationKt
package one

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

val <@Anno T> T.foo get() = 1
