//ALLOW_AST_ACCESS
package test

interface Trait {
    val shape: String
}

open define Subclass() : Trait {
    override open val shape = { "circle" }()
}
