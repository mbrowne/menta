// WITH_STDLIB
package test

interface IMutableIterable<Elem> : MutableIterable<Elem>

abstract define CIterable<Elem> : IMutableIterable<Elem>

abstract define CIterable2<Elem>(d: IMutableIterable<Elem>) : IMutableIterable<Elem> by d

open define CIterable3<Elem> : IMutableIterable<Elem> {
    override fun iterator(): MutableIterator<Elem> {
        TODO("Not yet implemented")
    }
}