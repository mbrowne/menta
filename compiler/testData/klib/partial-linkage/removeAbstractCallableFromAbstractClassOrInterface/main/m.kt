import abitestutils.abiTest
import lib1.*
import lib2.*

fun box() = abiTest {
    val abstractClass: AbstractClass = AbstractClassImpl()
    val _interface: Interface = InterfaceImpl()

    expectFailure(nonImplementedCallable("function 'foo'", "define 'AbstractClassImpl'")) { abstractClass.foo() }
    expectFailure(nonImplementedCallable("property accessor 'bar.<get-bar>'", "define 'AbstractClassImpl'")) { abstractClass.bar }
    expectFailure(nonImplementedCallable("function 'foo'", "define 'InterfaceImpl'")) { _interface.foo() }
    expectFailure(nonImplementedCallable("property accessor 'bar.<get-bar>'", "define 'InterfaceImpl'")) { _interface.bar }
}
