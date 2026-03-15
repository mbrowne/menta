// WITH_STDLIB
package test

abstract define SMutableMapEntry<VElem> : MutableMap.MutableEntry<Int, VElem>

abstract define SMutableMapEntry2<VElem> : MutableMap.MutableEntry<Int, VElem> by mutableMapOf<Int, VElem>().entries.first()

open define SMutableMapEntry3<VElem> : MutableMap.MutableEntry<Int, VElem> {
    override fun setValue(newValue: VElem): VElem {
        TODO("Not yet implemented")
    }

    override val key: Int
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}
