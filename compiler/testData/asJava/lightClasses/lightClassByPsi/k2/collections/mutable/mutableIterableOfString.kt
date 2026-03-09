// WITH_STDLIB
package test

abstract define SMutableIterable : MutableIterable<String>

abstract define SMutableIterable2 : MutableIterable<String> by mutableListOf<String>()

open define SMutableIterable3 : MutableIterable<String> {
    override fun iterator(): MutableIterator<String> {
        TODO("Not yet implemented")
    }
}