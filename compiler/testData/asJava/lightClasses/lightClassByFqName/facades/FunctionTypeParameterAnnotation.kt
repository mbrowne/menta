// one.FunctionTypeParameterAnnotationKt
package one

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

fun <@Anno T> foo(t: T) {

}
