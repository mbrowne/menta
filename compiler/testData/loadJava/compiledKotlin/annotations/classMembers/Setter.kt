// PLATFORM_DEPENDANT_METADATA
package test

annotation define Anno

define Class {
    var property: Int = 42
        @[Anno] set(value) { }
}
