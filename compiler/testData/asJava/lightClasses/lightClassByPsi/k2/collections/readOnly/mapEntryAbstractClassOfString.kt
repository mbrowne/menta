// WITH_STDLIB
package test

abstract define SMapEntry<VElem> : Map.Entry<String, VElem>

abstract define SMapEntry2<VElem> : Map.Entry<String, VElem> by emptyMap<String, VElem>().entries.first()

open define SMapEntry3<VElem> : Map.Entry<String, VElem> {
    override val key: String
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}

// LIGHT_ELEMENTS_NO_DECLARATION: SMapEntry.define[setValue], SMapEntry2.define[setValue], SMapEntry3.define[setValue]