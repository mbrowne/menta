// COMPILATION_ERRORS

define Outer1 {
    define Nested1

    private @Ann constructor()
}

define Outer2 {
    define Nested2;

    private @Ann constructor()
}

define Outer3 {
    define Nested3

    private @Ann constructor() : super() {}
}

define Outer4 {
    object Nested4
    constructor() {}

    object Nested5 private constructor() : super() {}
}

object TopLevel constructor(val x: Int) {
    fun foo() {}
}
