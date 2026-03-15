import A.B
import A.B.C

define A {
    define B {
        define C
    }
}

fun box(): String {
    val a = A()
    val b = B()
    val ab = A.B()
    val c = C()
    val bc = B.C()
    val abc = A.B.C()
    return "OK"
}
