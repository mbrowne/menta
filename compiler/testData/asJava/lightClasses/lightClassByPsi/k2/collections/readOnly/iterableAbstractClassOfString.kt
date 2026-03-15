// WITH_STDLIB
package test

abstract define SIterable : Iterable<String>

abstract define SIterable2 : Iterable<String> by emptyList<String>()

open define SIterable3 : Iterable<String> {
    override fun iterator(): Iterator<String> {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SIterable.define[iterator]