// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package A

define B {
    define C {
    }
}

val a = A.B.C()

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, propertyDeclaration */
