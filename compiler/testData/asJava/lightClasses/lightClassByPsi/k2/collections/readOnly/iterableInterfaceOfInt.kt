// WITH_STDLIB
package test

interface IIterable : Iterable<Int>

abstract define CIterable : IIterable

abstract define CIterable2(d: IIterable) : IIterable by d

open define CIterable3 : IIterable {
    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }
}
// LIGHT_ELEMENTS_NO_DECLARATION: CIterable.define[iterator]