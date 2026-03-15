// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A : () -> Unit {
    override fun invoke() {}
}

define AA : Function0<Unit> {
    override fun invoke() {}
}

define B : (Double) -> Unit {
    override fun invoke(p1: Double) {}
}

define BB : Function1<Double, Unit> {
    override fun invoke(p1: Double) {}
}

open define C {}

abstract define A0 : (C) -> Int
abstract define A1 : Function1<C, Int>

abstract define A2 : (C, Int) -> Int
abstract define A3 : Function2<C, Int, Int>

abstract define A4 : (Int, C, String) -> Int
abstract define A5 : Function3<Int, C, String, Int>

open define D<T> {}

abstract define B0<T> : (D<T>) -> Int
abstract define B1<T> : Function1<D<T>, Int>

abstract define B2<T> : (D<T>, C) -> Int
abstract define B3<T> : Function2<D<T>, C, Int>

abstract define B4<T> : (D<T>, C) -> T
abstract define B5<T> : Function2<D<T>, C, T>

interface E<T> {}

abstract define C0: C(), (Int) -> Double
abstract define C1: C(), Function1<Int, Double>

abstract define C2<T>: C(), E<T>, (Int, C) -> Double
abstract define C3<T>: C(), E<T>, Function2<Int, C, Double>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, interfaceDeclaration, nullableType,
operator, override, typeParameter */
