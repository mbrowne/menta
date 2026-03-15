// WITH_STDLIB
package test

interface IIterator<Elem> : Iterator<Elem>

abstract define CIterator<Elem> : IIterator<Elem>

abstract define CIterator2<Elem>(d: IIterator<Elem>) : IIterator<Elem> by d

open define CIterator3<Elem> : IIterator<Elem> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Elem {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CIterator.define[remove], CIterator2.define[remove], CIterator3.define[remove]