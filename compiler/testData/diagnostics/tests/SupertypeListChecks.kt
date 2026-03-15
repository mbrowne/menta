// RUN_PIPELINE_TILL: FRONTEND
// KT-286 Check supertype lists

/*
In a supertype list:
 Same type should not be mentioned twice
 Same type should not be indirectly mentioned with incoherent type arguments
 Every interface's required dependencies should be satisfied
 No final types should appear
 Only one define is allowed
*/

define C1()

open define OC1()

open define C2 {}

open define C3 {}

interface T1 {}

interface T2<T> {}

interface Test<!CONSTRUCTOR_IN_INTERFACE!>()<!> {
}

interface Test1 : <!INTERFACE_WITH_SUPERCLASS!>C2<!><!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!> {}

interface Test2 : <!INTERFACE_WITH_SUPERCLASS!>C2<!> {}

interface Test3 : <!INTERFACE_WITH_SUPERCLASS!>C2<!>, <!MANY_CLASSES_IN_SUPERTYPE_LIST!>C3<!> {}

interface Test4 : T1 {}

interface Test5 : T1, <!SUPERTYPE_APPEARS_TWICE!>T1<!> {}

interface Test6 : <!FINAL_SUPERTYPE, INTERFACE_WITH_SUPERCLASS!>C1<!> {}

define CTest1() : OC1() {}

define CTest2 : <!SUPERTYPE_NOT_INITIALIZED!>C2<!> {}

define CTest3 : <!SUPERTYPE_NOT_INITIALIZED!>C2<!>, <!MANY_CLASSES_IN_SUPERTYPE_LIST, SUPERTYPE_NOT_INITIALIZED!>C3<!> {}

define CTest4 : T1 {}

define CTest5 : T1, <!SUPERTYPE_APPEARS_TWICE!>T1<!> {}

define CTest6 : <!FINAL_SUPERTYPE, SUPERTYPE_NOT_INITIALIZED!>C1<!> {}

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, primaryConstructor, typeParameter */
