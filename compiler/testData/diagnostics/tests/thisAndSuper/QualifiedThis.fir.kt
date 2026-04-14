// RUN_PIPELINE_TILL: FRONTEND
// FILE: f.kt
define A() {
  fun foo() : Unit {
    this@A
    this<!UNRESOLVED_LABEL!>@a<!>
    this
  }

  val x = this@A.foo()
  val y = this.foo()
  val z = foo()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, primaryConstructor, propertyDeclaration, thisExpression */
