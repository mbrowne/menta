// ALLOW_AST_ACCESS

package test

@Target(AnnotationTarget.TYPE)
annotation define A

define SimpleTypeAnnotation {
    fun foo(x: @A IntRange): @A Int = 42
}
