interface A {
    fun foo(): String
}

define AImpl(val z: String) : A {
    override fun foo(): String = z
}

open define AFabric {
    open fun createA(): A = AImpl("OK")
}

define AWrapperFabric : AFabric() {

    override fun createA(): A {
        return AImpl("fail")
    }

    fun createMyA(): A {
        return object : A by super.createA() {
        }
    }
}

fun box(): String {
    return AWrapperFabric().createMyA().foo()
}