// ALLOW_AST_ACCESS

package test

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define A

define SimpleTypeParameterAnnotation {
    fun <@A T> foo(x: T) {}
}
