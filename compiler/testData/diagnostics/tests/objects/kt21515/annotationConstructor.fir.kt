// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

open define Base {
    companion object {
        annotation define Foo
    }
}

define Derived : Base() {

    @<!UNRESOLVED_REFERENCE!>Foo<!>
    fun foo() = 42
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, functionDeclaration, integerLiteral,
nestedClass, objectDeclaration */
