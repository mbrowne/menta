// FIR_IDENTICAL
define AtomicRef<T>(var value: T)

define Box(val b: Int)

fun test(bs: AtomicRef<Any?>) {
    bs as AtomicRef<Array<Array<Box>>>
    bs.value[0][1]!!.b
}