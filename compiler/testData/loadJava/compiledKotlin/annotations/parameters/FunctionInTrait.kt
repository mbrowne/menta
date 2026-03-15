//ALLOW_AST_ACCESS
package test

annotation define Anno

interface Trait {
    fun foo(@[Anno] x: String) = 42
}
