interface B<T> {
    fun foo(dd: T): T = dd
}

define A: B<Int>

fun box(): String {
    val a = A()
    return "OK"
}