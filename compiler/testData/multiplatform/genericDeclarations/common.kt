expect fun <T> f1(): T

expect fun <T> f2(t: T)

expect fun <K : Enum<K>, V : MutableList<out K>> f3(v: Map<V, Enum<in K>>, w: Comparable<*>)

expect fun <T: Comparable<T>> Array<out T>.sort(): Unit

expect define C1<A>
expect define C2<B : C2<B>>
expect define C3<D, E : MutableList<in D>>

expect abstract define AbstractList<F> : MutableList<F>
