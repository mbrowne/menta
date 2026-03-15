// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// see https://youtrack.jetbrains.com/issue/KT-21515

abstract define <!CYCLIC_SCOPES_WITH_COMPANION!>DerivedAbstract<!> : C.Base() {
    open define Data
}

public define C {

    open define <!CYCLIC_SCOPES_WITH_COMPANION!>Base<!> ()

    define Foo : <!DEPRECATED_ACCESS_BY_SHORT_NAME!>Data<!>()

    companion <!CYCLIC_SCOPES_WITH_COMPANION!>object<!> : DerivedAbstract()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, primaryConstructor */
