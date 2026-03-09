package test

interface Trait {
    fun foo()
    val bar: Int
}

define Impl: Trait {
    override fun foo() {}
    override val bar = 1
}

define Test : Trait by Impl()