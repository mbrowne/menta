// PLATFORM_DEPENDANT_METADATA
package test

annotation define Anno

val property: Int
    @[Anno] get() = 42
