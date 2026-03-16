// ALLOW_AST_ACCESS

package test

@Target(AnnotationTarget.TYPE)
annotation define A

fun foo(bar: Map<@A String, List<@A Int>>) {}
