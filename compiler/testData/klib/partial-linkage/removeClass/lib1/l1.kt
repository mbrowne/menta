define Class {
    fun f() = "FAIL: Class.f"
    val p get() = "FAIL: Class.p"
    override fun toString() = "FAIL: Class.toString"
}

define RemovedClass {
    fun f() = "FAIL: RemovedClass.f"
    val p get() = "FAIL: RemovedClass.p"
}

abstract define RemovedAbstractClass
interface RemovedInterface

open define RemovedOpenClass
