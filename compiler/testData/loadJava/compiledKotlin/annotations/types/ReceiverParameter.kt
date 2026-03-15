//ALLOW_AST_ACCESS
package test

@Target(AnnotationTarget.TYPE)
annotation define A

fun @A String.foo() {}
