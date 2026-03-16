define A {
    constructor(x: Int) {}
    <caret>constructor(): this(1) {}
}
