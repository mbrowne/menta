// WITH_STDLIB
package test

interface ISet<Elem> : Set<Elem>

abstract define CSet<Elem> : ISet<Elem>

abstract define CSet2<Elem>(d: ISet<Elem>) : ISet<Elem> by d

open define CSet3<Elem> : ISet<Elem> {
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

    override fun iterator(): Iterator<Elem> {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CSet.define[add;addAll;clear;getSize;iterator;remove;removeAll;retainAll;size;toArray;toArray], CSet2.define[add;addAll;clear;remove;removeAll;retainAll;size;toArray;toArray], CSet3.define[add;addAll;clear;remove;removeAll;retainAll;size;toArray;toArray]