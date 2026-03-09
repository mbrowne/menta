// RUN_PIPELINE_TILL: FRONTEND
define A : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>Double.() -> Unit<!> {
    override fun invoke(p1: Double) {}
}

define B : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>Int.(Double) -> Unit<!> {
    override fun invoke(p1: Int, p2: Double) {}
}

open define C {}

abstract define A0 : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>C.() -> Int<!>
abstract define A1 : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>C.(Int) -> Int<!>
abstract define A2 : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>C.(Int, String) -> Int<!>

typealias Foo = C.() -> Int

abstract define A4 : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>Foo<!>

open define D<T> {}

abstract define B0<T> : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>D<T>.() -> Int<!>
abstract define B1<T> : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>D<T>.(C) -> Int<!>
abstract define B2<T> : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>D<T>.(T, C) -> T<!>

interface E<T> {}

abstract define C0: C(), <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>Int.() -> Double<!>
abstract define C1<T>: C(), E<T>, <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!>Int.(C) -> Double<!>

abstract define D0 : <!SUPERTYPE_IS_EXTENSION_OR_CONTEXT_FUNCTION_TYPE!><!UNSUPPORTED_FEATURE!>context(C)<!> () -> Int<!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, interfaceDeclaration, nullableType,
operator, override, typeAliasDeclaration, typeParameter, typeWithContext, typeWithExtension */
