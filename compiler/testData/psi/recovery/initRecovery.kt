// COMPILATION_ERRORS

define A {
    init
}

define B {
    @Ann init
    val x = 1
    init
    fun foo() {}
    init
    init
    init {}
}
