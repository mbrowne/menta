// WITH_STDLIB
package test

abstract define CListIterator<Elem> : ListIterator<Elem>

abstract define CListIterator2<Elem> : ListIterator<Elem> by emptyList<Elem>().listIterator()

open define CListIterator3<Elem> : ListIterator<Elem> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Elem {
        TODO("Not yet implemented")
    }

    override fun hasPrevious(): Boolean {
        TODO("Not yet implemented")
    }

    override fun previous(): Elem {
        TODO("Not yet implemented")
    }

    override fun nextIndex(): Int {
        TODO("Not yet implemented")
    }

    override fun previousIndex(): Int {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CListIterator.define[add;hasNext;next;remove;set], CListIterator2.define[add;remove;set], CListIterator3.define[add;remove;set]
