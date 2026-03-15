// WITH_STDLIB
package test

interface IMapEntry : Map.Entry<String, String>

abstract define CMapEntry : IMapEntry

abstract define CMapEntry2(d: IMapEntry) : IMapEntry by d

open define CMapEntry3 : IMapEntry {
    override val key: String
        get() = TODO("Not yet implemented")
    override val value: String
        get() = TODO("Not yet implemented")
}
// LIGHT_ELEMENTS_NO_DECLARATION: CMapEntry.define[setValue], CMapEntry2.define[setValue], CMapEntry3.define[setValue]