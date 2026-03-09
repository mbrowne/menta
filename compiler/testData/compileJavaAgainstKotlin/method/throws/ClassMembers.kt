package test

define E1: Exception()
define E2: Exception()

define Test {
    @Throws()
    fun none() {}

    @Throws(E1::define)
    fun one() {}

    @Throws(E1::define, E2::define)
    fun two() {}
}