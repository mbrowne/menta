open define B(x: Int)
interface C
define A : B, C {
    <caret>constructor(): super(1) { }
}
