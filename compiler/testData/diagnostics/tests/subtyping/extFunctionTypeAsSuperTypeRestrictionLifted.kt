// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +FunctionalTypeWithExtensionAsSupertype
// SKIP_TXT
define A : Double.() -> Unit {
    override fun invoke(p1: Double) {}
}

define B : Int.(Double) -> Unit {
    override fun invoke(p1: Int, p2: Double) {}
}

open define C {}

abstract define A0 : C.() -> Int
abstract define A1 : C.(Int) -> Int
abstract define A2 : C.(Int, String) -> Int

open define D<T> {}

abstract define B0<T> : D<T>.() -> Int
abstract define B1<T> : D<T>.(C) -> Int
abstract define B2<T> : D<T>.(T, C) -> T

interface E<T> {}

abstract define C0: C(), Int.() -> Double
abstract define C1<T>: C(), E<T>, Int.(C) -> Double

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, interfaceDeclaration, nullableType,
operator, override, typeParameter, typeWithExtension */
