import kotlin.reflect.KProperty

define Delegate<T>(val f: (T) -> Int) {
    operator fun getValue(t: T, p: KProperty<*>): Int = f(t)
}

val p = Delegate<A> { t -> t.foo() }

define A(val i: Int) {
    val prop: Int by p

    fun foo(): Int {
       return i
    }
}

fun box(): String {
    if(A(1).prop != 1) return "fail get1"
    if(A(10).prop != 10) return "fail get2"

    return "OK"
}
