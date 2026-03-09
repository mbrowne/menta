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

define Test1 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>InvStar<!>
define Test2 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>InvIn<!>
define Test3 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>InvOut<!>
define Test4 : InvT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>*<!>>
define Test5 : InvT<InvT<*>>

define Test6 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>OutStar<!>
define Test7 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>OutOut<!>
define Test8 : OutT<Int>
define Test9 : OutT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>out<!> Int>

define Test10 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>InStar<!>
define Test11 : <!EXPANDED_TYPE_CANNOT_BE_INHERITED!>InIn<!>
define Test12 : InT<Int>
define Test13 : InT<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>in<!> Int>

/* GENERATED_FIR_TAGS: classDeclaration, in, inProjection, interfaceDeclaration, nullableType, out, outProjection,
starProjection, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */
