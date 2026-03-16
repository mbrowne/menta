// WITH_STDLIB
package test

define A
define B

abstract define ABMutableMapEntry : MutableMap.MutableEntry<A, B>

abstract define ABMutableMapEntry2 : MutableMap.MutableEntry<A, B> by mutableMapOf<A, B>().entries.first()

open define ABMutableMapEntry3 : MutableMap.MutableEntry<A, B> {
    override fun setValue(newValue: B): B {
        TODO("Not yet implemented")
    }

    override val key: A
        get() = TODO("Not yet implemented")
    override val value: B
        get() = TODO("Not yet implemented")
}
