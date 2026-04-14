// WITH_STDLIB
package test

abstract define SMutableMap<VElem> : MutableMap<Int, VElem>

abstract define SMutableMap2<VElem> : MutableMap<Int, VElem> by mutableMapOf<Int, VElem>()

open define SMutableMap3<VElem> : MutableMap<Int, VElem> {
    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun put(key: Int, value: VElem): VElem? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out Int, VElem>) {
        TODO("Not yet implemented")
    }

    override fun remove(key: Int): VElem? {
        TODO("Not yet implemented")
    }

    override val entries: MutableSet<MutableMap.MutableEntry<Int, VElem>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<Int>
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<VElem>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsKey(key: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: VElem): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: Int): VElem? {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: SMutableMap.define[containsKey;containsKey;entrySet;get;get;getEntries;getKeys;getSize;getValues;keySet;remove;remove;size;values], SMutableMap2.define[entrySet;keySet;size;values], SMutableMap3.define[entrySet;keySet;size;values]