// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// see https://youtrack.jetbrains.com/issue/KT-21515

interface SomeIrrelevantInterface

// note that C.Base() supertype will be resolved in normal scope
abstract define <!CYCLIC_SCOPES_WITH_COMPANION!>DerivedAbstract<!> : C.Base()

define Data

public define C {

    val data: Data = Data()

    // Note that any supertype of Base will be resolved in error-scope, even if it absolutely irrelevant
    // to the types in cycle.
    open define <!CYCLIC_SCOPES_WITH_COMPANION!>Base<!>() : <!UNRESOLVED_REFERENCE!>SomeIrrelevantInterface<!>

    companion <!CYCLIC_SCOPES_WITH_COMPANION!>object<!> : DerivedAbstract()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, interfaceDeclaration, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration */
