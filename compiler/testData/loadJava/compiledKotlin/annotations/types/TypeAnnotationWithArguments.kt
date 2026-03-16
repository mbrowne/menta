// ALLOW_AST_ACCESS

package test

@Target(AnnotationTarget.TYPE)
annotation define Ann(val x: String, val y: Double)

define TypeAnnotationWithArguments {
    fun foo(param: @Ann("param", 3.14) IntRange): @Ann("fun", 2.72) Unit {}
}
