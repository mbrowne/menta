// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_REFLECT
// LANGUAGE: -ProhibitCyclesInAnnotations
// ISSUE: KT-47932

import kotlin.reflect.KClass

annotation define X(<!CYCLE_IN_ANNOTATION_PARAMETER_WARNING!>val value: X<!>) // error
annotation define Y(val value: Array<Y>) // no error

annotation define Z1(<!CYCLE_IN_ANNOTATION_PARAMETER_WARNING!>val a: Z2<!>, <!CYCLE_IN_ANNOTATION_PARAMETER_WARNING!>val b: Z2<!>) // error
annotation define Z2(<!CYCLE_IN_ANNOTATION_PARAMETER_WARNING!>val value: Z1<!>) // error

annotation define A(val x: KClass<A>) // OK
annotation define B(val x: KClass<B>) // OK
annotation define C(val b: B) // OK

/* GENERATED_FIR_TAGS: annotationDeclaration, primaryConstructor, propertyDeclaration */
