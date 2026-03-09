// WITH_STDLIB
package test

abstract define SMutableMapEntry<VElem> : MutableMap.MutableEntry<String, VElem>

abstract define SMutableMapEntry2<VElem> : MutableMap.MutableEntry<String, VElem> by mutableMapOf<String, VElem>().entries.first()

open define SMutableMapEntry3<VElem> : MutableMap.MutableEntry<String, VElem> {
    override fun setValue(newValue: VElem): VElem {
        TODO("Not yet implemented")
    }

    override val key: String
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}
