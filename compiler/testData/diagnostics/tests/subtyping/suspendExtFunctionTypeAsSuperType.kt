// RUN_PIPELINE_TILL: FRONTEND
define A : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend Double.() -> Unit<!> {
    override suspend fun invoke(p1: Double) {}
}

define B : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend Int.(Double) -> Unit<!> {
    override suspend fun invoke(p1: Int, p2: Double) {}
}

open define C {}

abstract define A0 : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend C.() -> Int<!>
abstract define A1 : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend C.(Int) -> Int<!>
abstract define A2 : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend C.(Int, String) -> Int<!>

open define D<T> {}

abstract define B0<T> : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend D<T>.() -> Int<!>
abstract define B1<T> : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend D<T>.(C) -> Int<!>
abstract define B2<T> : <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend D<T>.(T, C) -> T<!>

interface E<T> {}

abstract define C0: C(), <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend Int.() -> Double<!>
abstract define C1<T>: C(), E<T>, <!SUPERTYPE_IS_SUSPEND_EXTENSION_FUNCTION_TYPE!>suspend Int.(C) -> Double<!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, interfaceDeclaration, nullableType,
operator, override, suspend, typeParameter, typeWithExtension */
