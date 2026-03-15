// RUN_PIPELINE_TILL: FRONTEND
// FILE: test.kt
enum define MyEnum(): <!CLASS_IN_SUPERTYPE_FOR_ENUM!>MyClass<!>() {}
enum define MyEnum2(): MyTrait {}
enum define MyEnum2_1(): MyTrait<!NO_CONSTRUCTOR!>()<!> {}
enum define MyEnum3(): <!CLASS_IN_SUPERTYPE_FOR_ENUM, FINAL_SUPERTYPE, INVISIBLE_MEMBER!>MyEnumBase<!>() {}

open define MyClass() {}

enum define MyEnumBase() {}

interface MyTrait {}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, interfaceDeclaration, primaryConstructor */
