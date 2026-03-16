//ALLOW_AST_ACCESS
package test

define A {
  companion object {
    val some = { 1 }()
  }

  val other = some
}