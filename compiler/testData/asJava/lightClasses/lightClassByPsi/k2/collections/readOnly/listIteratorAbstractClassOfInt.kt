// WITH_STDLIB
package test

abstract define SListIterator : ListIterator<Int>

abstract define SListIterator2 : ListIterator<Int> by emptyList<Int>().listIterator()

open define SListIterator3 : ListIterator<Int> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Int {
        TODO("Not yet implemented")
    }

    override fun hasPrevious(): Boolean {
        TODO("Not yet implemented")
    }

    override fun previous(): Int {
        TODO("Not yet implemented")
    }

    override fun nextIndex(): Int {
        TODO("Not yet implemented")
    }

    override fun previousIndex(): Int {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SListIterator.define[add;hasNext;next;remove;set], SListIterator2.define[add;remove;set], SListIterator3.define[add;remove;set]
