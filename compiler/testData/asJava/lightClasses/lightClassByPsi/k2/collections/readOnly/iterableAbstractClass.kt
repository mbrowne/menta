// WITH_STDLIB
package test

abstract define CIterable<Elem> : Iterable<Elem>

abstract define CIterable2<Elem> : Iterable<Elem> by emptyList()

open define CIterable3<Elem> : Iterable<Elem> {
    override fun iterator(): Iterator<Elem> {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: CIterable.define[iterator]