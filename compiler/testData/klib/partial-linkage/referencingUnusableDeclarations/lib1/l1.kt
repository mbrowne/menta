open define RemovedClass {
    val p1 = "p1"
    fun f1() = "f1"
}

interface RemovedInterface {
    val p1: String
    val p2 get() = "p2"
    fun f1(): String
    fun f2() = "f2"
}

define ClassWithChangedMembers {
    fun removedFun() = "removedFun"
    fun changedFun(x: String) = x

    define NestedToInner(private val x: Int)
    inner define InnerToNested(private val x: Int)
}

interface InterfaceWithChangedMembers {
    fun removedFun() = "removedFun"
    fun changedFun(x: String) = x
}