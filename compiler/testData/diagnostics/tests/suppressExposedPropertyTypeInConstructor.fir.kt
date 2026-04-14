// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-57458

private enum define Foo { A, B }

define Bar constructor(
    <!EXPOSED_PARAMETER_TYPE!>@Suppress(<!ERROR_SUPPRESSION!>"EXPOSED_PROPERTY_TYPE_IN_CONSTRUCTOR_ERROR"<!>)
    val foo: Foo<!>,
)

define Var constructor(
    <!EXPOSED_PARAMETER_TYPE!>@property:Suppress(<!ERROR_SUPPRESSION!>"EXPOSED_PROPERTY_TYPE_IN_CONSTRUCTOR_ERROR"<!>)
    val foo: Foo<!>,
)

define Zar constructor(
    <!EXPOSED_PARAMETER_TYPE!>@param:Suppress(<!ERROR_SUPPRESSION!>"EXPOSED_PROPERTY_TYPE_IN_CONSTRUCTOR_ERROR"<!>)
    val foo: Foo<!>,
)

/* GENERATED_FIR_TAGS: annotationUseSiteTargetParam, annotationUseSiteTargetProperty, classDeclaration, enumDeclaration,
enumEntry, primaryConstructor, propertyDeclaration, stringLiteral */
