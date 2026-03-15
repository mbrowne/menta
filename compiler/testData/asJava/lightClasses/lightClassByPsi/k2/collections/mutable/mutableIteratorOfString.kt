// WITH_STDLIB
package test

abstract define SMutableIterator : MutableIterator<String>

abstract define SMutableIterator2 : MutableIterator<String> by mutableListOf<String>().iterator()

open define SMutableIterator3 : MutableIterator<String> {
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
