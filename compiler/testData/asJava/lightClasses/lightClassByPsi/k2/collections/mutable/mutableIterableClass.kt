// WITH_STDLIB
package test

abstract define CMutableIterable<Elem> : MutableIterable<Elem>

abstract define CMutableIterable2<Elem> : MutableIterable<Elem> by mutableListOf<Elem>()

open define CMutableIterable3<Elem> : MutableIterable<Elem> {
    override fun iterator(): MutableIterator<Elem> {
        TODO("Not yet implemented")
    }
}