// WITH_STDLIB
package test

interface IMutableIterator : MutableIterator<Int>

abstract define CIterator : IMutableIterator

abstract define CIterator2(d: IMutableIterator) : IMutableIterator by d

open define CIterator3 : IMutableIterator {
    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Int {
        TODO("Not yet implemented")
    }
}