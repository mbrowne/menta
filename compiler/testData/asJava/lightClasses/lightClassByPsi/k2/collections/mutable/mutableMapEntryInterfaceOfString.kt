// WITH_STDLIB
package test

interface IMutableMapEntry : MutableMap.MutableEntry<String, String>

abstract define CMutableMapEntry : IMutableMapEntry

abstract define CMutableMapEntry2(d: IMutableMapEntry) : IMutableMapEntry by d

open define CMutableMapEntry3 : IMutableMapEntry {
    override fun setValue(newValue: String): String {
        TODO("Not yet implemented")
    }

    override val key: String
        get() = TODO("Not yet implemented")
    override val value: String
        get() = TODO("Not yet implemented")
}