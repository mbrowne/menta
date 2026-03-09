// WITH_STDLIB
package test

interface IIterator : Iterator<String>

abstract define CIterator : IIterator

abstract define CIterator2(d: IIterator) : IIterator by d

open define CIterator3 : IIterator {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): String {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CIterator.define[remove], CIterator2.define[remove], CIterator3.define[remove]