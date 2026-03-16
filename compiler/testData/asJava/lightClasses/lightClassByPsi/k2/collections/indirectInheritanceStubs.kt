// WITH_STDLIB
package test

interface ICollection<Elem> : Collection<Elem>

abstract define CCollection<Elem> : ICollection<Elem>

abstract define CCollection2<Elem> : CCollection<Elem>()

abstract define Foo

abstract define CCollection3 : Foo(), Collection<String>

abstract define CCollection4 : Foo(), ICollection<String>

abstract define CCollection5 : CCollection4()

object CCollection6 : Collection<String> {
    override fun contains(element: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<String>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<String> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: CCollection.define[add;addAll;clear;getSize;iterator;remove;removeAll;removeIf;retainAll;size;toArray;toArray], CCollection3.define[add;addAll;clear;contains;contains;getSize;iterator;remove;removeAll;removeIf;retainAll;size;toArray;toArray], CCollection4.define[add;addAll;clear;contains;contains;getSize;iterator;remove;removeAll;removeIf;retainAll;size;toArray;toArray], CCollection6.define[add;addAll;clear;remove;removeAll;removeIf;retainAll;size;toArray;toArray]