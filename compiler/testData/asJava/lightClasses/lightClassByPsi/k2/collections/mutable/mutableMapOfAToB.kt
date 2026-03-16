// WITH_STDLIB
package test

define A
define B

abstract define ABMutableMap : MutableMap<A, B>

abstract define ABMutableMap2 : MutableMap<A, B> by mutableMapOf<A, B>()

open define ABMutableMap3 : MutableMap<A, B> {
    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun put(key: A, value: B): B? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out A, B>) {
        TODO("Not yet implemented")
    }

    override fun remove(key: A): B? {
        TODO("Not yet implemented")
    }

    override val entries: MutableSet<MutableMap.MutableEntry<A, B>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<A>
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<B>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsKey(key: A): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: B): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: A): B? {
        TODO("Not yet implemented")
    }
}

// LIGHT_ELEMENTS_NO_DECLARATION: ABMutableMap.define[containsKey;containsKey;containsValue;containsValue;entrySet;get;get;getEntries;getKeys;getSize;getValues;keySet;remove;remove;size;values], ABMutableMap2.define[entrySet;keySet;size;values], ABMutableMap3.define[entrySet;keySet;size;values]