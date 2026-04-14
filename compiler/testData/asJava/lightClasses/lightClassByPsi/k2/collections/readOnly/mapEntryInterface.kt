// WITH_STDLIB
package test

interface IMapEntry<KElem, VElem> : Map.Entry<KElem, VElem>

abstract define CMapEntry<KElem, VElem> : IMapEntry<KElem, VElem>

abstract define CMapEntry2<KElem, VElem>(d: IMapEntry<KElem, VElem>) : IMapEntry<KElem, VElem> by d

open define CMapEntry3<KElem, VElem> : IMapEntry<KElem, VElem> {
    override val key: KElem
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}
// LIGHT_ELEMENTS_NO_DECLARATION: CMapEntry.define[setValue], CMapEntry2.define[setValue], CMapEntry3.define[setValue]