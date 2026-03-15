// WITH_STDLIB
package test

abstract define SMutableSet : MutableSet<Int>

abstract define SMutableSet2 : MutableSet<Int> by mutableSetOf<Int>()

open define SMutableSet3 : MutableSet<Int> {
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

// LIGHT_ELEMENTS_NO_DECLARATION: SMutableSet.define[contains;contains;getSize;remove;remove;size;toArray;toArray], SMutableSet2.define[size;toArray;toArray], SMutableSet3.define[size;toArray;toArray]