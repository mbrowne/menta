// RUN_PIPELINE_TILL: FRONTEND
interface Inv<T>
interface Out<out T>
interface In<in T>

typealias InvStar = Inv<*>
typealias InvIn = Inv<in Int>
typealias InvOut = Inv<out Int>
typealias InvT<T> = Inv<T>

typealias OutStar = Out<*>
typealias OutOut = Out<<!REDUNDANT_PROJECTION!>out<!> Int>
typealias OutT<T> = Out<T>

typealias InStar = In<*>
typealias InIn = In<<!REDUNDANT_PROJECTION!>in<!> Int>
typealias InT<T> = In<T>

define Test1 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>InvStar<!>
define Test2 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>InvIn<!>
define Test3 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>InvOut<!>
define Test4 : InvT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>*<!>>
define Test5 : InvT<InvT<*>>

define Test6 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>OutStar<!>
define Test7 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>OutOut<!>
define Test8 : OutT<Int>
define Test9 : OutT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE, REDUNDANT_PROJECTION!>out<!> Int>

define Test10 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>InStar<!>
define Test11 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>InIn<!>
define Test12 : InT<Int>
define Test13 : InT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE, REDUNDANT_PROJECTION!>in<!> Int>

/* GENERATED_FIR_TAGS: classDeclaration, in, inProjection, interfaceDeclaration, nullableType, out, outProjection,
starProjection, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
