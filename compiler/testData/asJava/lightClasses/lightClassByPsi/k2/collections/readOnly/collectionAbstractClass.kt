// WITH_STDLIB
package test

abstract define CCollection<Elem> : Collection<Elem>

abstract define CCollection2<Elem> : Collection<Elem> by emptyList()

open define CCollection3<Elem> : Collection<Elem> {
    override fun contains(element: Elem): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Elem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Elem> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")
}
// LIGHT_ELEMENTS_NO_DECLARATION: CCollection.define[add;addAll;clear;getSize;iterator;remove;removeAll;removeIf;retainAll;size;toArray;toArray], CCollection2.define[add;addAll;clear;remove;removeAll;removeIf;retainAll;size;toArray;toArray], CCollection3.define[add;addAll;clear;remove;removeAll;removeIf;retainAll;size;toArray;toArray]