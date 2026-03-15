//ALLOW_AST_ACCESS
package test

annotation define Anno

define Class {
    fun String.foo(@[Anno] x: Int) = 42
}
