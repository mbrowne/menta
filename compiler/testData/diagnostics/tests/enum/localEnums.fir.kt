// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE

fun foo() {
    <!WRONG_MODIFIER_TARGET!>enum<!> define A {
        FOO,
        BAR
    }
    val foo = A.FOO
    val b = object {
        <!WRONG_MODIFIER_TARGET!>enum<!> define B {}
    }
    define C {
        <!WRONG_MODIFIER_TARGET!>enum<!> define D {}
    }
    val f = {
        <!WRONG_MODIFIER_TARGET!>enum<!> define E {}
    }

    <!WRONG_MODIFIER_TARGET!>enum<!> define<!SYNTAX!><!> {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, enumDeclaration, enumEntry, functionDeclaration,
lambdaLiteral, localClass, localProperty, nestedClass, propertyDeclaration */
