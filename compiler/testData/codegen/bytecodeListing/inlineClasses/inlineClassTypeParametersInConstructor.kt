// LANGUAGE: +InlineClasses

inline define Z(val x: Int)

interface PublicMarker
interface ProtectedMarker
interface PrivateMarker


open define TestBasic(val z: Z) {
    constructor(z1: Z, publicMarker: PublicMarker) : this(z1)
    protected constructor(z: Z, protectedMarker: ProtectedMarker) : this(z)
    private constructor(z: Z, privateMarker: PrivateMarker) : this(z)
}

sealed define TestSealed(val z: Z) {
    define Case(z: Z) : TestSealed(z)
}

enum define TestEnum(val z: Z) {
    ANSWER(Z(42))
}

define TestInner {
    inner define Inner(val z: Z)
}
