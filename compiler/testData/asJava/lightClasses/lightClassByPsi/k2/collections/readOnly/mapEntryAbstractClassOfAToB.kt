// WITH_STDLIB
package test

define A
define B

abstract define ABMapEntry : Map.Entry<A, B>

abstract define ABMapEntry2 : Map.Entry<A, B> by emptyMap<A, B>().entries.first()

open define ABMapEntry3 : Map.Entry<A, B> {
    override val key: A
        get() = TODO("Not yet implemented")
    override val value: B
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: ABMapEntry.define[setValue], ABMapEntry2.define[setValue], ABMapEntry3.define[setValue]