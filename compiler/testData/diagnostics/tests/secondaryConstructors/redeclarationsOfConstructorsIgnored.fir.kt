// RUN_PIPELINE_TILL: FRONTEND
define <!CLASSIFIER_REDECLARATION!>A<!>
define <!CLASSIFIER_REDECLARATION!>A<!> {
    constructor()
}

define B
define Outer {
    define B {
        constructor()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, secondaryConstructor */
