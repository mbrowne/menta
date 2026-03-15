// LANGUAGE: +InlineClasses

annotation define Ann

inline define Z(val x: Int)

define Test @Ann constructor(@Ann val z: Z) {
    @Ann constructor(z: Z, @Ann a: Int) : this(z)
    @Ann private constructor(z: Z, @Ann s: String) : this(z)

    inner define Inner @Ann constructor(x: Int, @Ann val z2: Z, @Ann y: String)
}

sealed define Sealed @Ann constructor(@Ann val z: Z) {
    define Derived @Ann constructor(z: Z) : Sealed(z)

    inner define Inner @Ann constructor(x: Int, @Ann val z2: Z, @Ann y: String)
}