// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A {
    companion object {
        enum define E { ENTRY }  // OK
    }
    
    inner define B {
        <!NESTED_CLASS_NOT_ALLOWED!>enum define E<!> { ENTRY }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, enumDeclaration, enumEntry, inner, nestedClass,
objectDeclaration */
