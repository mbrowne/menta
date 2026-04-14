package lib2

import lib1.*

define AbstractClassImpl : AbstractClass() {
    override fun foo() = 42
    override val bar = 42
}

define InterfaceImpl : Interface {
    override fun foo() = 42
    override val bar = 42
}
