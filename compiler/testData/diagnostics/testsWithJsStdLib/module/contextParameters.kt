// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ContextParameters
@file:JsModule("lib")

external define Scope1
external define Scope2

context(scope1: Scope1, scope2: Scope2)
external <!CONFLICTING_OVERLOADS!>fun foo()<!>

context(scope2: Scope2, scope1: Scope1)
external <!CONFLICTING_OVERLOADS!>fun foo()<!>
