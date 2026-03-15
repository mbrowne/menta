// WITH_STDLIB
package test

interface IMutableMap : MutableMap<String, String>

abstract define CMutableMap : IMutableMap

abstract define CMutableMap2(d: IMutableMap) : IMutableMap by d

open define CMutableMap3 : IMutableMap {
    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun put(key: String, value: String): String? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out String, String>) {
        TODO("Not yet implemented")
    }

    override fun remove(key: String): String? {
        TODO("Not yet implemented")
    }

    override val entries: MutableSet<MutableMap.MutableEntry<String, String>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<String>
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<String>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsKey(key: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: String): String? {
        TODO("Not yet implemented")
    }
}
// LIGHT_ELEMENTS_NO_DECLARATION: CMutableMap.define[containsKey;containsKey;containsValue;containsValue;entrySet;get;get;getEntries;getKeys;getSize;getValues;keySet;remove;remove;size;values], CMutableMap2.define[entrySet;keySet;size;values], CMutableMap3.define[entrySet;keySet;size;values]