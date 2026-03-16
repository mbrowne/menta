//ALLOW_AST_ACCESS
package test

annotation define Anno(val t: String)
@Anno("foo") suspend fun foo() {}
