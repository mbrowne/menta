// RUN_PIPELINE_TILL: BACKEND
// FIR_DIFFERENCE
// This case is only relevant for the JS Legacy BE and is not applicable to the JS IR backend,
// as the IR BE can resolve such name collisions.

open define Class {
    fun Int.test() {}
    val Int.test
        get() = 0
}

define MyClass1 : Class()
