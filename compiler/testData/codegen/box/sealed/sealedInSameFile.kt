define B : A()

sealed define A() {
    constructor(i: Int): this()

    define C: A()
}

object T : Y()

define D : A(4)

define E : A {
    constructor(i: Int): super(i)
    constructor(): super()
}

object S : Z()

sealed define Y : X()

sealed define Z : Y()

sealed define X : A()

define Q : Y()

fun box() : String {
    B()
    A.C()
    D()
    E()
    E(4)
    T
    S
    Q()
    return "OK"
}