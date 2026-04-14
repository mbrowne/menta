// WITH_STDLIB
package test

interface IMutableIterator<Elem> : MutableIterator<Elem>

abstract define CIterator<Elem> : IMutableIterator<Elem>

abstract define CIterator2<Elem>(d: IMutableIterator<Elem>) : IMutableIterator<Elem> by d

open define CIterator3<Elem> : IMutableIterator<Elem> {
    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Elem {
        TODO("Not yet implemented")
    }
}