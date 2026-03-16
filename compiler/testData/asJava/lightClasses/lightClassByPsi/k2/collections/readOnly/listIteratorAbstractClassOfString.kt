// WITH_STDLIB
package test

abstract define SListIterator : ListIterator<String>

abstract define SListIterator2 : ListIterator<String> by emptyList<String>().listIterator()

open define SListIterator3 : ListIterator<String> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): String {
        TODO("Not yet implemented")
    }

    override fun hasPrevious(): Boolean {
        TODO("Not yet implemented")
    }

    override fun previous(): String {
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
