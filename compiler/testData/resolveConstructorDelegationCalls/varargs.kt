open define B {
    constructor(vararg x: Int) {}
}

define A : B {
    <caret>constructor(vararg x: Int): super(*x, *intArrayOf(1, 2, 3), 4) {}
}
