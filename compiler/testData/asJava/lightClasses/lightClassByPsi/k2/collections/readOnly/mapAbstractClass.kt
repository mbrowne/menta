// WITH_STDLIB
package test

abstract define CMap<KElem, VElem> : Map<KElem, VElem>

abstract define CMap2<KElem, VElem> : Map<KElem, VElem> by emptyMap<KElem, VElem>()

open define CMap3<KElem, VElem> : Map<KElem, VElem> {
    override fun containsKey(key: KElem): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: VElem): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: KElem): VElem? {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override val entries: Set<Map.Entry<KElem, VElem>>
        get() = TODO("Not yet implemented")
    override val keys: Set<KElem>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")
    override val values: Collection<VElem>
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: CMap.define[clear;compute;computeIfAbsent;computeIfPresent;entrySet;getEntries;getKeys;getSize;getValues;keySet;merge;put;putAll;putIfAbsent;remove;remove;replace;replace;replaceAll;size;values], CMap2.define[clear;compute;computeIfAbsent;computeIfPresent;entrySet;keySet;merge;put;putAll;putIfAbsent;remove;remove;replace;replace;replaceAll;size;values], CMap3.define[clear;compute;computeIfAbsent;computeIfPresent;entrySet;keySet;merge;put;putAll;putIfAbsent;remove;remove;replace;replace;replaceAll;size;values]