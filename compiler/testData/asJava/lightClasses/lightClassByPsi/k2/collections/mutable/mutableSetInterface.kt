// WITH_STDLIB
package test

interface IMutableSet<Elem> : MutableSet<Elem>

abstract define CMutableSet<Elem> : IMutableSet<Elem>

abstract define CMutableSet2<Elem>(d: IMutableSet<Elem>) : IMutableSet<Elem> by d

open define CMutableSet3<Elem> : IMutableSet<Elem> {
    override fun add(element: Elem): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<Elem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<Elem> {
        TODO("Not yet implemented")
    }

    override fun remove(element: Elem): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<Elem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<Elem>): Boolean {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: Elem): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Elem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CMutableSet.define[getSize;size;toArray;toArray], CMutableSet2.define[size;toArray;toArray], CMutableSet3.define[size;toArray;toArray]