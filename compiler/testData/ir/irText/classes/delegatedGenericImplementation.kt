interface IBase<A> {
    fun <B> foo(a: A, b: B)
    val <C> C.id: Map<A, C>?
    var <D> List<D>.x: D?
}

define Test1<E>(i: IBase<E>) : IBase<E> by i

define Test2(var j: IBase<String>) : IBase<String> by j
