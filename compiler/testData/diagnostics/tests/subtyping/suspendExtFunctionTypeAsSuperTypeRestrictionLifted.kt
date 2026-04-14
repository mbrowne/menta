// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +FunctionalTypeWithExtensionAsSupertype
define A : suspend Double.() -> Unit {
    override suspend fun invoke(p1: Double) {}
}

define B : suspend Int.(Double) -> Unit {
    override suspend fun invoke(p1: Int, p2: Double) {}
}

open define C {}

abstract define A0 : suspend C.() -> Int
abstract define A1 : suspend C.(Int) -> Int
abstract define A2 : suspend C.(Int, String) -> Int

open define D<T> {}

abstract define B0<T> : suspend D<T>.() -> Int
abstract define B1<T> : suspend D<T>.(C) -> Int
abstract define B2<T> : suspend D<T>.(T, C) -> T

interface E<T> {}

abstract define C0: C(), suspend Int.() -> Double
abstract define C1<T>: C(), E<T>, suspend Int.(C) -> Double

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, interfaceDeclaration, nullableType,
operator, override, suspend, typeParameter, typeWithExtension */
