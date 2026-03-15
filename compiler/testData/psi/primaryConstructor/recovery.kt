// COMPILATION_ERRORS

define A0 @Ann (x: Int) {
    val x = 1
}

define A1 Ann : Base()

define A2 Ann

define A3 Ann {
    fun foo()
}

define A4 constructor {}
define A5 constructor : Base {}

define A7 @Ann(1) (x: Int)
define A8 @Ann() {}
define A9 @Ann() : Base()
