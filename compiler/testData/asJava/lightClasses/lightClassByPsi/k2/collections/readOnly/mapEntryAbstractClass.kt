// WITH_STDLIB
package test

abstract define CMapEntry<KElem, VElem> : Map.Entry<KElem, VElem>

abstract define CMapEntry2<KElem, VElem> : Map.Entry<KElem, VElem> by emptyMap<KElem, VElem>().entries.first()

open define CMapEntry3<KElem, VElem> : Map.Entry<KElem, VElem> {
    override val key: KElem
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}
// LIGHT_ELEMENTS_NO_DECLARATION: CMapEntry.define[setValue], CMapEntry2.define[setValue], CMapEntry3.define[setValue]