// COMPILATION_ERRORS

@[]
define A {
    @[] val x = 1

    @[@q]
    fun foo() {
        @[] define A
    }

    @[@q1 @ @q2]
    fun foo2() {}

    @[
    fun bar() {}
}
