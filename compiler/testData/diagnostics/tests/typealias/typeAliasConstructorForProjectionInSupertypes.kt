// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-60305

open define C<T>

typealias CStar = C<*>
typealias CIn = C<in Int>
typealias COut = C<out Int>
typealias CT<T> = C<T>

define Test1 : CStar()
define Test2 : CIn()
define Test3 : COut()

define Test4 : CStar {
    constructor() : super()
}

define Test5 : CT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>*<!>>()

/* GENERATED_FIR_TAGS: classDeclaration, inProjection, nullableType, outProjection, secondaryConstructor, starProjection,
typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
