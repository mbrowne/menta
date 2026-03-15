// RUN_PIPELINE_TILL: FRONTEND
package foo

fun test() {
  A.d
  A.Companion.<!INVISIBLE_MEMBER!>f<!>
  B.<!INVISIBLE_MEMBER!>D<!>
  <!INVISIBLE_MEMBER!>CCC<!>
  CCC.<!INVISIBLE_MEMBER!>classObjectVar<!>
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
