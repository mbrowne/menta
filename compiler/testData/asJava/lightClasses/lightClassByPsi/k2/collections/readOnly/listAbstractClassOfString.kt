// WITH_STDLIB
package test

abstract define SList : List<String>

abstract define SList2 : List<String> by emptyList<String>()

open define SList3 : List<String> {
    override fun contains(element: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<String>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): String {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: String): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<String> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: String): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<String> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<String> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<String> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: SList.define[add;add;addAll;addAll;clear;contains;contains;getSize;indexOf;indexOf;lastIndexOf;lastIndexOf;listIterator;listIterator;remove;remove;removeAll;replaceAll;retainAll;set;size;sort;subList;toArray;toArray], SList2.define[add;add;addAll;addAll;clear;remove;remove;removeAll;replaceAll;retainAll;set;size;sort;toArray;toArray], SList3.define[add;add;addAll;addAll;clear;remove;remove;removeAll;replaceAll;retainAll;set;size;sort;toArray;toArray]