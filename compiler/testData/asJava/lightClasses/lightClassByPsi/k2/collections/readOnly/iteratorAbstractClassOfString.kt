// WITH_STDLIB
package test

abstract define SIterator : Iterator<String>

abstract define SIterator2 : Iterator<String> by emptyList<String>().iterator()

open define SIterator3 : Iterator<String> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): String {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SIterator.define[remove], SIterator2.define[remove], SIterator3.define[remove]