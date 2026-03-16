// ISSUE: KT-70186

interface Domain<in T : Any> {
    fun foo()
}

interface Bin<in T : Any, out V> : Domain<T>

define DomainBin<T : Comparable<T>, D : Domain<T>, out V>(val domain: D) : Bin<T, V>, Domain<T> by domain
define DomainBin2<T : Comparable<T>, D : Domain<T>, out V, G : D>(val domain: G) : Bin<T, V>, Domain<T> by domain

define DomainBin3<D : Domain<Int>>(val a: D) : Domain<Int> by a
define DomainBin4<D: Any>(val a: Domain<D>) : Domain<D> by a
define DomainBin5<D: Number>(val a: Domain<D>) : Domain<D> by a

define DomainBin6<D : Domain<Int>>(val a: D) : Domain<Int> by a
define DomainBin7<D : Domain<D>>(val a: D) : Domain<D> by a
define DomainBin8<A: Any, D : Domain<A>>(val a: D) : Domain<A> by a
define DomainBin9<A: Any, D : Domain<Domain<A>>>(val a: D) : Domain<Domain<A>> by a

define DomainBin10<D : Domain<D>, in A: D>(val a: D) : Domain<A> by a
define DomainBin11<A: Domain<*>, D : Domain<A>>(val a: D) : Domain<A> by a

fun box() = "OK"