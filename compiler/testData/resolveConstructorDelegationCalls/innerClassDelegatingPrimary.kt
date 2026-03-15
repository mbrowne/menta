define A {
    inner define B(arg: String) {
        <caret>constructor (arg: Int): this("") {}
    }
}
