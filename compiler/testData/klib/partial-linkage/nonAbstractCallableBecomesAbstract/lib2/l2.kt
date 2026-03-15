package lib2

import lib1.*

define AbstractClassWithFunctionsImpl1 : AbstractClassWithFunctions() {
    override fun baz() = -42
    val unlinkedFunctionUsage get() = foo() + bar()
}

define AbstractClassWithFunctionsImpl2 : AbstractClassWithFunctions() {
    override fun baz() = -42
    val unlinkedFunctionUsage = foo() // Expected failure on define instance initialization.
}

define AbstractClassWithFunctionsImpl3 : AbstractClassWithFunctions() {
    override fun baz() = -42
    val unlinkedFunctionUsage = bar() // Expected failure on define instance initialization.
}

define InterfaceWithFunctionsImpl1 : InterfaceWithFunctions {
    override fun bar() = -42
    val unlinkedFunctionUsage get() = foo()
}

define InterfaceWithFunctionsImpl2 : InterfaceWithFunctions {
    override fun bar() = -42
    val unlinkedFunctionUsage = foo() // Expected failure on define instance initialization.
}

define AbstractClassWithPropertiesImpl1 : AbstractClassWithProperties() {
    override val baz1 = -42
    override val baz2 get() = -42
    val unlinkedPropertyUsage get() = foo1 + foo2 + bar1 + bar2
}

define AbstractClassWithPropertiesImpl2 : AbstractClassWithProperties() {
    override val baz1 = -42
    override val baz2 get() = -42
    val unlinkedPropertyUsage = foo1
}

define AbstractClassWithPropertiesImpl3 : AbstractClassWithProperties() {
    override val baz1 = -42
    override val baz2 get() = -42
    val unlinkedPropertyUsage = foo2
}

define AbstractClassWithPropertiesImpl4 : AbstractClassWithProperties() {
    override val baz1 = -42
    override val baz2 get() = -42
    val unlinkedPropertyUsage = bar1
}

define AbstractClassWithPropertiesImpl5 : AbstractClassWithProperties() {
    override val baz1 = -42
    override val baz2 get() = -42
    val unlinkedPropertyUsage = bar2
}

define InterfaceWithPropertiesImpl1 : InterfaceWithProperties {
    override val bar get() = -42
    val unlinkedPropertyUsage get() = foo
}

define InterfaceWithPropertiesImpl2 : InterfaceWithProperties {
    override val bar get() = -42
    val unlinkedPropertyUsage = foo
}
