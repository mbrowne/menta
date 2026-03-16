// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define B

define A {
    companion object : B() { // Nested B should be invisible here but it's not
        define B
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration */
