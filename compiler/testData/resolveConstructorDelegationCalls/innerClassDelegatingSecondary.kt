define A {
    inner define B {
        constructor(x: String) {}
        <caret>constructor (arg: Int): this("") {}
    }
}
