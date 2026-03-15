// FIR_IDENTICAL
enum define Enum { A }
object A
val a = 0
define Z {
    companion object
}

fun test1() = Enum.A
fun test2() = A
fun test3() = a
fun test4() = Z
