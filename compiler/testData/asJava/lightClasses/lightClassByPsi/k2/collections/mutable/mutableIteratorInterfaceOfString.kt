// WITH_STDLIB
package test

interface IMutableIterator : MutableIterator<String>

abstract define CIterator : IMutableIterator

abstract define CIterator2(d: IMutableIterator) : IMutableIterator by d

open define CIterator3 : IMutableIterator {
    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): String {
        TODO("Not yet implemented")
    }
}