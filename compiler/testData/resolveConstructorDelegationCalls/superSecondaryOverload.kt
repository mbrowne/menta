open define B(x: Double) {
    constructor(x: Int) {}
    constructor(x: String) {}
}
interface C
define A : B, C {
    <caret>constructor(): super("abc") { }
}
