// WITH_STDLIB
package test

interface IMutableMapEntry : MutableMap.MutableEntry<Int, Int>

abstract define CMutableMapEntry : IMutableMapEntry

abstract define CMutableMapEntry2(d: IMutableMapEntry) : IMutableMapEntry by d

open define CMutableMapEntry3 : IMutableMapEntry {
    override fun setValue(newValue: Int): Int {
        TODO("Not yet implemented")
    }

    override val key: Int
        get() = TODO("Not yet implemented")
    override val value: Int
        get() = TODO("Not yet implemented")
}