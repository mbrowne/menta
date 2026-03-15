// WITH_STDLIB
package test

interface IMutableIterable : MutableIterable<String>

abstract define CIterable : IMutableIterable

abstract define CIterable2(d: IMutableIterable) : IMutableIterable by d

open define CIterable3 : IMutableIterable {
    override fun iterator(): MutableIterator<String> {
        TODO("Not yet implemented")
    }
}