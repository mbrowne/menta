open define B<R1, R2>(x: R1, y: R2)

define A<T1, T2> : B<T1, Int> {
    <caret>constructor(x: T1, y: Int): super(x, y) {}
}
