// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A {
    companion object B {
        define <!REDECLARATION!>G<!>
        val <!REDECLARATION!>G<!> = 1
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, integerLiteral, nestedClass, objectDeclaration,
propertyDeclaration */
