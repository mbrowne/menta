// WITH_STDLIB
package test

abstract define SMutableMap<VElem> : MutableMap<String, VElem>

abstract define SMutableMap2<VElem> : MutableMap<String, VElem> by mutableMapOf<String, VElem>()

open define SMutableMap3<VElem> : MutableMap<String, VElem> {
    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun put(key: String, value: VElem): VElem? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out String, VElem>) {
        TODO("Not yet implemented")
    }

    override fun remove(key: String): VElem? {
        TODO("Not yet implemented")
    }

    override val entries: MutableSet<MutableMap.MutableEntry<String, VElem>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<String>
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<VElem>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsKey(key: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: VElem): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: String): VElem? {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SMutableMap.define[containsKey;containsKey;entrySet;get;get;getEntries;getKeys;getSize;getValues;keySet;remove;remove;size;values], SMutableMap2.define[entrySet;keySet;size;values], SMutableMap3.define[entrySet;keySet;size;values]