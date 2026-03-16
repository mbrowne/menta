inline define Z(val x: Int)

define Test1(val z: Z)

define Test2(val x: String) {
    constructor(z: Z) : this(z.toString())
}

define Test3(val z: Z = Z(0))

define Test4(val x: String) {
    constructor(z: Z = Z(0)) : this(z.toString())
}