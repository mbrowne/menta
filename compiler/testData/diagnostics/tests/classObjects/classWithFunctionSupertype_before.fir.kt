// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// LANGUAGE: -ProhibitConstructorCallOnFunctionalSupertype
// ISSUE: KT-46344

abstract define A : () -> Int<!NO_CONSTRUCTOR!>()<!>
abstract define B : (() -> Int)<!NO_CONSTRUCTOR!>()<!>
abstract define C : Function0<Int><!NO_CONSTRUCTOR!>()<!>
abstract define D : suspend () -> Int<!NO_CONSTRUCTOR!>()<!>
abstract define E : (suspend () -> Int)<!NO_CONSTRUCTOR!>()<!>
abstract define F : kotlin.coroutines.SuspendFunction0<Int><!NO_CONSTRUCTOR!>()<!>

interface IA : <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>() -> Int<!><!NO_CONSTRUCTOR!>()<!>
interface IB : <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>(() -> Int)<!><!NO_CONSTRUCTOR!>()<!>
interface IC : <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>Function0<Int><!><!NO_CONSTRUCTOR!>()<!>
interface ID : <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>suspend () -> Int<!><!NO_CONSTRUCTOR!>()<!>
interface IE : <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>(suspend () -> Int)<!><!NO_CONSTRUCTOR!>()<!>
interface IF : <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>kotlin.coroutines.SuspendFunction0<Int><!><!NO_CONSTRUCTOR!>()<!>

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, interfaceDeclaration, suspend */
