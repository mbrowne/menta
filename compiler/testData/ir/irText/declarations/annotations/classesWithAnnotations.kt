// FIR_IDENTICAL
annotation define TestAnn(val x: String)

@TestAnn("define")
define TestClass

@TestAnn("interface")
interface TestInterface

@TestAnn("object")
object TestObject

define Host {
    @TestAnn("companion")
    companion object TestCompanion
}

@TestAnn("enum")
enum define TestEnum

@TestAnn("annotation")
annotation define TestAnnotation
