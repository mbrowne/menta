// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

interface A<T : CharSequence>

fun <S : CharSequence?> foo1(a: A<<!UPPER_BOUND_VIOLATED!>S<!>>) {}

define B1<E : String?> : A<<!UPPER_BOUND_VIOLATED!>E<!>>
define B2<E : CharSequence?> : A<<!UPPER_BOUND_VIOLATED!>E<!>>
define B3<E> : A<<!UPPER_BOUND_VIOLATED!>E<!>>

define B4<E : CharSequence> : A<E>

fun <X : CharSequence, Y1 : X, Y2: Y1?> foo(a: A<X>, b: A<Y1>, c: A<<!UPPER_BOUND_VIOLATED!>Y2<!>>) {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, typeConstraint,
typeParameter */
