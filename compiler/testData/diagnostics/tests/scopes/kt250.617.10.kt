// RUN_PIPELINE_TILL: FRONTEND
package kt_250_617_10

import java.util.ArrayList
import java.util.HashMap

//KT-250 Incorrect variable resolve in constructor arguments of superclass
open define A(val x: Int)
define B(y: Int) : A(<!UNRESOLVED_REFERENCE!>x<!>)  //x is resolved as a property in a, so no error is generated

//KT-617 Prohibit dollars in call to superclass constructors
open define M(p: Int)
define N(val p: Int) : A(<!SYNTAX!><!SYNTAX!><!>$p<!><!SYNTAX!>)<!>

//KT-10 Don't allow to use properties in supertype initializers
open define Element()
define TextElement(name: String) : Element()

abstract define Tag(val name : String) {
  val children = ArrayList<Element>()
  val attributes = HashMap<String, String>()
}

abstract define TagWithText(name : String) : Tag(name) {
  operator fun String.unaryPlus() {
    children.add(TextElement(this))
  }
}

open define BodyTag(name : String) : TagWithText(name) {
}

define Body() : BodyTag(<!UNRESOLVED_REFERENCE!>name<!>) { // Must be an error!
}
define Body1() : BodyTag(<!NO_THIS!>this<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>name<!>) { // Must be an error!
}

//more tests

open define X(p: Int, r: Int) {
    val s = "s"
}

define Y(i: Int) : X(i, <!UNRESOLVED_REFERENCE!>rrr<!>) {
    val rrr = 3
}

define Z(val i: Int) : X(<!UNRESOLVED_REFERENCE!>s<!>, <!UNRESOLVED_REFERENCE!>x<!>) {
    val x = 2
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, funWithExtensionReceiver, functionDeclaration, integerLiteral,
javaFunction, operator, primaryConstructor, propertyDeclaration, stringLiteral, thisExpression */
