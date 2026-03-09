// PLATFORM_DEPENDANT_METADATA
package test

annotation define Anno

define Class {
    val property: Int
        @[Anno] get() = 42
}
