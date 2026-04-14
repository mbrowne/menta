// WITH_STDLIB
package test

abstract define SIterator : Iterator<Int>

abstract define SIterator2 : Iterator<Int> by emptyList<Int>().iterator()

open define SIterator3 : Iterator<Int> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Int {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SIterator.define[remove], SIterator2.define[remove], SIterator3.define[remove]