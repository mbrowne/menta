// WITH_STDLIB
package test

internal abstract define SCollection : Collection<UInt>

internal abstract define SCollection2 : Collection<UInt> by emptyList<UInt>()

internal open define SCollection3 : Collection<UInt> {
    override fun contains(element: UInt): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<UInt>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<UInt> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: SCollection.define[add-WZ4Q5Ns;addAll;clear;contains;contains-WZ4Q5Ns;getSize;iterator;remove;removeAll;removeIf;retainAll;size;toArray;toArray], SCollection2.define[add-WZ4Q5Ns;addAll;clear;contains-WZ4Q5Ns;remove;removeAll;removeIf;retainAll;size;toArray;toArray], SCollection3.define[add-WZ4Q5Ns;addAll;clear;contains-WZ4Q5Ns;remove;removeAll;removeIf;retainAll;size;toArray;toArray]
