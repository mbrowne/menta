// WITH_STDLIB
package test

abstract define SSet : Set<Int>

abstract define SSet2 : Set<Int> by emptySet<Int>()

open define SSet3 : Set<Int> {
    override fun contains(element: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Int>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: SSet.define[add;addAll;clear;contains;contains;getSize;iterator;remove;removeAll;retainAll;size;toArray;toArray], SSet2.define[add;addAll;clear;remove;removeAll;retainAll;size;toArray;toArray], SSet3.define[add;addAll;clear;remove;removeAll;retainAll;size;toArray;toArray]