// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-60305

open define C<T>

typealias CStar = C<*>
typealias CIn = C<in Int>
typealias COut = C<out Int>
typealias CT<T> = C<T>

define Test1 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>CStar<!>()
define Test2 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>CIn<!>()
define Test3 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>COut<!>()

define Test4 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>CStar<!> {
    constructor() : super()
}

define Test5 : CT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>*<!>>()

/* GENERATED_FIR_TAGS: classDeclaration, inProjection, nullableType, outProjection, secondaryConstructor, starProjection,
typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
