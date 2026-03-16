// WITH_STDLIB
package test

abstract define SMapEntry<VElem> : Map.Entry<Int, VElem>

abstract define SMapEntry2<VElem> : Map.Entry<Int, VElem> by emptyMap<Int, VElem>().entries.first()

open define SMapEntry3<VElem> : Map.Entry<Int, VElem> {
    override val key: Int
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: SMapEntry.define[setValue], SMapEntry2.define[setValue], SMapEntry3.define[setValue]