//ALLOW_AST_ACCESS
package test

define TestFirst {
  companion object {
    fun testing(a: InnerClass) = 45
    fun testing(a: NotInnerClass) = 45
  }

  inner define InnerClass
  inner define NotInnerClass
}
