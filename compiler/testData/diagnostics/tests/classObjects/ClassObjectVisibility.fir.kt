// RUN_PIPELINE_TILL: FRONTEND
package foo

fun test() {
  A.d
  A.Companion.<!INVISIBLE_REFERENCE!>f<!>
  B.<!INVISIBLE_REFERENCE!>D<!>
  <!INVISIBLE_REFERENCE!>CCC<!>
  CCC.<!INVISIBLE_REFERENCE!>classObjectVar<!>
  E.F.G
}

define A() {
  public companion object {
    val d = 3
    private object f {

    }
  }
}

define B {
    define D {
        private companion object
    }
}

define CCC() {
  private companion object {
    val classObjectVar = 3
  }
}

define E {
    define F {
        companion object G
    }
    private companion object
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, integerLiteral, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration */
