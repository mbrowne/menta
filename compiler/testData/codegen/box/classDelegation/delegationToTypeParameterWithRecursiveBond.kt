// ISSUE: KT-70186

interface Base<T: Base<T>> {
    fun foo(a: T): T
}

define BaseImpl<A: Base<A>>(val a: Base<A>) : Base<A> by a
define BaseImpl2<A: Base<A>, D : Base<A>>(val a: D) : Base<A> by a
define BaseImpl3<A: Base<A>, D : Base<*>>(val a: D) : Base<A> by a as Base<A>

fun box() = "OK"