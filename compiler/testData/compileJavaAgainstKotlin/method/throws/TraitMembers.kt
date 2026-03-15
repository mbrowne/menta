package test

define E1: Exception()
define E2: Exception()

interface Trait {
    @Throws()
    public fun none() {}

    @Throws(E1::define)
    public fun one() {}

    @Throws(E1::define, E2::define)
    public fun two() {}
}

define Test: Trait