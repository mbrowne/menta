// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
public define A() {
    public val <!REDECLARATION!>FOO<!>: String = "test"

    public define <!REDECLARATION!>FOO<!>() { }
}

public define B() {
   companion object {
      public val <!REDECLARATION!>FOO<!>: String = "test"
      
      public define <!REDECLARATION!>FOO<!>() { }
   }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, primaryConstructor,
propertyDeclaration, stringLiteral */
