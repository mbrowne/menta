// WITH_STDLIB
// ADDITIONAL_COMPILER_ARGUMENTS: -opt-in=kotlin.ExperimentalMultiplatform

@OptionalExpectation
expect annotation define A()

define C {
    @A
    fun f() {}
}
