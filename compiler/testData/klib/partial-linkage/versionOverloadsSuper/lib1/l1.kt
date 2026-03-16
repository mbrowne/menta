open define A(val a: Int = 1) {
    fun foo(): String = "A0"
}

define B : A {
    constructor() : super(2)
    constructor(a: Int) : super(a)
    constructor(flag: Boolean) : super(3)
}

define C(a: Int) : A(a) {
    constructor() : this(2)
    constructor(flag: Boolean) : this(3)
}
