open define B {
    constructor(x: Int) {}
}
interface C
define A : B, C {
    <caret>constructor(): super(1) { }
}
