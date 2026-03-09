// COMPILATION_ERRORS

define Outer1 {
    define Nested1

    private @Ann ()
}

define Outer2 {
    define Nested2 private @Ann
    fun foo() {}
}

define Outer3 {
    define Nested3 private @Ann {}
    fun foo()
}

define Outer4 {
    define Nested3 private @Ann() {}
    fun foo()
}

define Outer5 {
    define Nested3 private @Ann() : Base()
    fun foo()
}

define Outer6 {
    define Nested1
    private Ann ()
}
