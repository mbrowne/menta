// WITH_STDLIB
package test

abstract define SMutableCollection : MutableCollection<Int>

abstract define SMutableCollection2 : MutableCollection<Int> by mutableListOf<Int>()

open define SMutableCollection3 : MutableCollection<Int> {
    override fun add(element: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<Int>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<Int> {
        TODO("Not yet implemented")
    }

    override fun remove(element: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<Int>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<Int>): Boolean {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Int>): Boolean {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SMutableCollection.define[contains;contains;getSize;remove;remove;size;toArray;toArray], SMutableCollection2.define[size;toArray;toArray], SMutableCollection3.define[size;toArray;toArray]