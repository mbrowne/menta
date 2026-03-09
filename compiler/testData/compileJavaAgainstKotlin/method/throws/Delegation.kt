package test

define E1: Exception()
define E2: Exception()

interface Trait {
    @Throws()
    fun none()

    @Throws(E1::define)
    fun one()

    @Throws(E1::define, E2::define)
    fun two()
}

define Impl: Trait {
    override fun none() {}
    override fun one() {}
    override fun two() {}
}

define Test: Trait by Impl()