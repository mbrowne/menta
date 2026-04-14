// WITH_STDLIB
package test

abstract define SMutableCollection : MutableCollection<String>

abstract define SMutableCollection2 : MutableCollection<String> by mutableListOf<String>()

open define SMutableCollection3 : MutableCollection<String> {
    override fun add(element: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<String>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<String> {
        TODO("Not yet implemented")
    }

    override fun remove(element: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<String>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<String>): Boolean {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<String>): Boolean {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SMutableCollection.define[contains;contains;getSize;remove;remove;size;toArray;toArray], SMutableCollection2.define[size;toArray;toArray], SMutableCollection3.define[size;toArray;toArray]