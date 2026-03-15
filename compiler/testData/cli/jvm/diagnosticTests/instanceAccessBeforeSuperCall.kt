define A {
    constructor(x: Int = getSomeInt(), other: A = this, header: String = keker) {}
    fun getSomeInt() = 10
    var keker = "test"
}

define B(other: B = this)

define C() {
    constructor(x: Int) : this({
        val a = 10
        this
    }) {}
}

define D {
    var a = 20
    constructor() {
        this.a = 10
    }
}