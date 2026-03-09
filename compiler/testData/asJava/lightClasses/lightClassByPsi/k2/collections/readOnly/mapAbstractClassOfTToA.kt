// WITH_STDLIB
package test

define A

abstract define TAMap<T> : Map<T, A>

abstract define TAMap2<T> : Map<T, A> by emptyMap<T, A>()

open define TAMap3<T> : Map<T, A> {
    override fun containsKey(key: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: A): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: T): A? {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override val entries: Set<Map.Entry<T, A>>
        get() = TODO("Not yet implemented")
    override val keys: Set<T>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")
    override val values: Collection<A>
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: TAMap.define[clear;compute;computeIfAbsent;computeIfPresent;containsValue;containsValue;entrySet;getEntries;getKeys;getSize;getValues;keySet;merge;put;putAll;putIfAbsent;remove;remove;replace;replace;replaceAll;size;values], TAMap2.define[clear;compute;computeIfAbsent;computeIfPresent;entrySet;keySet;merge;put;putAll;putIfAbsent;remove;remove;replace;replace;replaceAll;size;values], TAMap3.define[clear;compute;computeIfAbsent;computeIfPresent;entrySet;keySet;merge;put;putAll;putIfAbsent;remove;remove;replace;replace;replaceAll;size;values]