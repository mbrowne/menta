// WITH_STDLIB
package test

abstract define SIterable : Iterable<Int>

abstract define SIterable2 : Iterable<Int> by emptyList<Int>()

open define SIterable3 : Iterable<Int> {
    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SIterable.define[iterator]