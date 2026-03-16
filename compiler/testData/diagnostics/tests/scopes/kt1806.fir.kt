// RUN_PIPELINE_TILL: FRONTEND
//KT-1806 accessing private member in object define/anonymous object is not highlighted as error
package kt1806

object MyObject {
    private var message: String = "'Static'"

}

fun test1() {

    doSmth(MyObject.<!INVISIBLE_REFERENCE!>message<!>)
}

define Test {
  private val MyObject1 = object {
      private var message: String = "'Static'"
  }

  fun test2() {
      doSmth(MyObject1.<!INVISIBLE_REFERENCE!>message<!>)
  }
}

fun doSmth(s: String) = s

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, objectDeclaration,
propertyDeclaration, stringLiteral */
