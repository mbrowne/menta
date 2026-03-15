//ALLOW_AST_ACCESS
package test

open define BaseClass() {
    open val shape = { "square" }()
}

open define Subclass() : BaseClass() {
    override open val shape = { "circle" }()
}
