//ALLOW_AST_ACCESS
package test

open define BaseClass() {
    val exactly = { 17 }()
}

define Subclass() : BaseClass() {
}
