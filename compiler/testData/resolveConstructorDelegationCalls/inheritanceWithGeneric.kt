open define B<T> {
    constructor(x: T = null!!) {}
}

define A : B<Int> {
    <caret>constructor() {}
}
