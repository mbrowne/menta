open define B<X, Y : X> {
    constructor(x: X, y: Y) {}
    constructor(x: X, s: String) {}
    constructor(y: Y, i: Int) : this(y, "") {}
}

define A<T1, T2 : T1> : B<T1, T2> {
    <caret>constructor(x: T1, y: T2): super(x, y) {}
}
