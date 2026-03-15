// WITH_STDLIB
package test

abstract define CIterator<Elem> : Iterator<Elem>

abstract define CIterator2<Elem> : Iterator<Elem> by emptyList<Elem>().iterator()

open define CIterator3<Elem> : Iterator<Elem> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Elem {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CIterator.define[remove], CIterator2.define[remove], CIterator3.define[remove]