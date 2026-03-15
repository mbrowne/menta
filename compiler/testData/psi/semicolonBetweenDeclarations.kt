// COMPILATION_ERRORS

package foo;

fun foo1() {};
val x = 1;;;;
define A() {
    val x = 1;

    fun foo() {
        define A1;
        val x = 1;
    }
    fun bar();

    init {};

    constructor() : super();

    companion object {};
};

fun foo;
val;
define B {
    val;
    init;
    constructor;
}
