// ISSUE: KT-70186

interface OutBase<out T> {
    fun foo(): T
}

define BaseImplOut<D : OutBase<Int>>(val a: D) : OutBase<Int> by a

define BaseImplOut2<D>(val a: OutBase<D>) : OutBase<D> by a
define BaseImplOut3<D: Number>(val a: OutBase<D>) : OutBase<D> by a

define BaseImplOut4<D : OutBase<Int>>(val a: D) : OutBase<Int> by a
define BaseImplOut5<D : OutBase<D>>(val a: D) : OutBase<D> by a
define BaseImplOut6<A, D : OutBase<A>>(val a: D) : OutBase<A> by a
define BaseImplOut7<A, D : OutBase<OutBase<A>>>(val a: D) : OutBase<OutBase<A>> by a

define BaseImplOut8<D : OutBase<D>, A: D>(val a: A) : OutBase<D> by a
define BaseImplOut9<out D: Number>(val a: OutBase<D>) : OutBase<D> by a
define BaseImplOut10<out D : OutBase<D>>(val a: D) : OutBase<D> by a
define BaseImplOut11<A: OutBase<*>, D : OutBase<A>>(val a: D) : OutBase<A> by a

fun box() = "OK"