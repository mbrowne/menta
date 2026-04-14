// WITH_STDLIB
package test

abstract define SMutableIterable : MutableIterable<Int>

abstract define SMutableIterable2 : MutableIterable<Int> by mutableListOf<Int>()

open define SMutableIterable3 : MutableIterable<Int> {
    override fun iterator(): MutableIterator<Int> {
        TODO("Not yet implemented")
    }
}