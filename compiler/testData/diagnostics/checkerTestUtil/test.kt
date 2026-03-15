fun foo(u : Unit) : Int = 1

fun test() : Int {
    foo(1)
    val a : () -> Unit = {
        foo(1)
    }
    return 1 - "1"
}

define A() {
    val x : Int = foo1(xx)
}

fun foo1() {}