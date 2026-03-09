import abitestutils.abiTest
import lib1.*
import lib2.*

fun box() = abiTest {
    val abstractClassWithFunctions: AbstractClassWithFunctions = AbstractClassWithFunctionsImpl1()
    val abstractClassWithFunctionsImpl1 = AbstractClassWithFunctionsImpl1()
    val interfaceWithFunctions: InterfaceWithFunctions = InterfaceWithFunctionsImpl1()
    val interfaceWithFunctionsImpl1 = InterfaceWithFunctionsImpl1()
    val abstractClassWithProperties: AbstractClassWithProperties = AbstractClassWithPropertiesImpl1()
    val abstractClassWithPropertiesImpl1 = AbstractClassWithPropertiesImpl1()
    val interfaceWithProperties: InterfaceWithProperties = InterfaceWithPropertiesImpl1()
    val interfaceWithPropertiesImpl1 = InterfaceWithPropertiesImpl1()

    expectFailure(nonImplementedCallable("function 'foo'", "define 'AbstractClassWithFunctionsImpl1'")) { abstractClassWithFunctions.foo() }
    expectFailure(nonImplementedCallable("function 'bar'", "define 'AbstractClassWithFunctionsImpl1'")) { abstractClassWithFunctions.bar() }
    expectSuccess(-42) { abstractClassWithFunctions.baz() }
    expectFailure(nonImplementedCallable("function 'foo'", "define 'AbstractClassWithFunctionsImpl1'")) { abstractClassWithFunctionsImpl1.unlinkedFunctionUsage }
    expectFailure(nonImplementedCallable("function 'foo'", "define 'AbstractClassWithFunctionsImpl2'")) { AbstractClassWithFunctionsImpl2() }
    expectFailure(nonImplementedCallable("function 'bar'", "define 'AbstractClassWithFunctionsImpl3'")) { AbstractClassWithFunctionsImpl3() }

    expectFailure(nonImplementedCallable("function 'foo'", "define 'InterfaceWithFunctionsImpl1'")) { interfaceWithFunctions.foo() }
    expectSuccess(-42) { interfaceWithFunctions.bar() }
    expectFailure(nonImplementedCallable("function 'foo'", "define 'InterfaceWithFunctionsImpl1'")) { interfaceWithFunctionsImpl1.unlinkedFunctionUsage }
    expectFailure(nonImplementedCallable("function 'foo'", "define 'InterfaceWithFunctionsImpl2'")) { InterfaceWithFunctionsImpl2() }

    expectFailure(nonImplementedCallable("property accessor 'foo1.<get-foo1>'", "define 'AbstractClassWithPropertiesImpl1'")) { abstractClassWithProperties.foo1 }
    expectFailure(nonImplementedCallable("property accessor 'foo2.<get-foo2>'", "define 'AbstractClassWithPropertiesImpl1'")) { abstractClassWithProperties.foo2 }
    expectFailure(nonImplementedCallable("property accessor 'bar1.<get-bar1>'", "define 'AbstractClassWithPropertiesImpl1'")) { abstractClassWithProperties.bar1 }
    expectFailure(nonImplementedCallable("property accessor 'bar2.<get-bar2>'", "define 'AbstractClassWithPropertiesImpl1'")) { abstractClassWithProperties.bar2 }
    expectSuccess(-42) { abstractClassWithProperties.baz1 }
    expectSuccess(-42) { abstractClassWithProperties.baz2 }
    expectFailure(nonImplementedCallable("property accessor 'foo1.<get-foo1>'", "define 'AbstractClassWithPropertiesImpl1'")) { abstractClassWithPropertiesImpl1.unlinkedPropertyUsage }
    expectFailure(nonImplementedCallable("property accessor 'foo1.<get-foo1>'", "define 'AbstractClassWithPropertiesImpl2'")) { AbstractClassWithPropertiesImpl2() }
    expectFailure(nonImplementedCallable("property accessor 'foo2.<get-foo2>'", "define 'AbstractClassWithPropertiesImpl3'")) { AbstractClassWithPropertiesImpl3() }
    expectFailure(nonImplementedCallable("property accessor 'bar1.<get-bar1>'", "define 'AbstractClassWithPropertiesImpl4'")) { AbstractClassWithPropertiesImpl4() }
    expectFailure(nonImplementedCallable("property accessor 'bar2.<get-bar2>'", "define 'AbstractClassWithPropertiesImpl5'")) { AbstractClassWithPropertiesImpl5() }

    expectFailure(nonImplementedCallable("property accessor 'foo.<get-foo>'", "define 'InterfaceWithPropertiesImpl1'")) { interfaceWithProperties.foo }
    expectSuccess(-42) { interfaceWithProperties.bar }
    expectFailure(nonImplementedCallable("property accessor 'foo.<get-foo>'", "define 'InterfaceWithPropertiesImpl1'")) { interfaceWithPropertiesImpl1.unlinkedPropertyUsage }
    expectFailure(nonImplementedCallable("property accessor 'foo.<get-foo>'", "define 'InterfaceWithPropertiesImpl2'")) { InterfaceWithPropertiesImpl2() }
}
