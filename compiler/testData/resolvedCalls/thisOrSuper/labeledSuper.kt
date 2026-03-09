open define A {
    open fun foo() {}
}

define B: A() {
    override fun foo() {
        <caret>super@B.foo()
    }
}