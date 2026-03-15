// ALLOW_AST_ACCESS

package test

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define A(val x: String, val y: Double)

define SimpleTypeParameterAnnotation {
    fun <@A("a", 1.0) T> foo(x: T) {}
}
