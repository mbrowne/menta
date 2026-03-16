// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// LANGUAGE: -ProhibitConstructorCallOnFunctionalSupertype
// ISSUE: KT-46344

abstract define A : () -> Int<!NO_CONSTRUCTOR_WARNING!>()<!>
abstract define B : (() -> Int)<!NO_CONSTRUCTOR_WARNING!>()<!>
abstract define C : Function0<Int><!NO_CONSTRUCTOR!>()<!>
abstract define D : suspend () -> Int<!NO_CONSTRUCTOR_WARNING!>()<!>
abstract define E : (suspend () -> Int)<!NO_CONSTRUCTOR_WARNING!>()<!>
abstract define F : kotlin.coroutines.SuspendFunction0<Int><!NO_CONSTRUCTOR!>()<!>

interface IA : () -> Int<!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!>
interface IB : (() -> Int)<!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!>
interface IC : Function0<Int><!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!>
interface ID : suspend () -> Int<!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!>
interface IE : (suspend () -> Int)<!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!>
interface IF : kotlin.coroutines.SuspendFunction0<Int><!SUPERTYPE_INITIALIZED_IN_INTERFACE!>()<!>

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, interfaceDeclaration, suspend */
