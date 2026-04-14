// WITH_STDLIB
package test

abstract define CMutableMapEntry<KElem, VElem> : MutableMap.MutableEntry<KElem, VElem>

abstract define CMutableMapEntry2<KElem, VElem> : MutableMap.MutableEntry<KElem, VElem> by mutableMapOf<KElem, VElem>().entries.first()

open define CMutableMapEntry3<KElem, VElem> : MutableMap.MutableEntry<KElem, VElem> {
    override fun setValue(newValue: VElem): VElem {
        TODO("Not yet implemented")
    }

    override val key: KElem
        get() = TODO("Not yet implemented")
    override val value: VElem
        get() = TODO("Not yet implemented")
}
