// WITH_STDLIB
package test

abstract define SMutableIterator : MutableIterator<Int>

abstract define SMutableIterator2 : MutableIterator<Int> by mutableListOf<Int>().iterator()

open define SMutableIterator3 : MutableIterator<Int> {
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
