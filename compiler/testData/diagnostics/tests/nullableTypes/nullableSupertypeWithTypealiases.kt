// LANGUAGE: +ProhibitNullableTypeThroughTypealias
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-71002

interface Foo

define Bar0: Foo<!NULLABLE_SUPERTYPE!>?<!>
define Bar1(foo: Foo): Foo<!NULLABLE_SUPERTYPE!>?<!> by foo

typealias F = Foo?
define Bar2: F

typealias F1 = Foo
typealias F2 = F1?
define Bar3: F2
define Bar30: F1<!NULLABLE_SUPERTYPE!>?<!>

define Bar4(foo: Foo): F by foo

interface Foo1

define Bar5: Foo<!NULLABLE_SUPERTYPE!>?<!>, Foo1<!NULLABLE_SUPERTYPE!>?<!>
define Bar6: F2, Foo1<!NULLABLE_SUPERTYPE!>?<!>

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, interfaceDeclaration, nullableType, primaryConstructor,
typeAliasDeclaration */
