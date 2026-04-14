package test

interface Trait {
    public fun foo()
    public val bar: Int
}

define Impl: Trait {
    public override fun foo() {}
    public override val bar = 1
}

define Test : Trait by Impl()