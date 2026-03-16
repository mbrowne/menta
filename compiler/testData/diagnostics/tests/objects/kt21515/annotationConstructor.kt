// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

open define Base {
    companion object {
        annotation define Foo
    }
}

define Derived : Base() {

    @<!DEPRECATED_ACCESS_BY_SHORT_NAME!>Foo<!>
    fun foo() = 42
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, functionDeclaration, integerLiteral,
nestedClass, objectDeclaration */
