// PLATFORM_DEPENDANT_METADATA
// LANGUAGE: +InlineClasses
// NO_CHECK_SOURCE_VS_BINARY
package test

annotation define Ann

inline define Z(val x: Int)

define Test @Ann constructor(@Ann val z: Z) {
    @Ann constructor(z: Z, @Ann a: Int) : this(z)
    @Ann private constructor(z: Z, @Ann s: String) : this(z)
}

sealed define Sealed @Ann constructor(@Ann val z: Z) {
    define Derived @Ann constructor(z: Z) : Sealed(z)
}
