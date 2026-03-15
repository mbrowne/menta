interface A {
    fun foo(): String
}

define AImpl(val z: String) : A {
    override fun foo(): String = z
}

open define AFabric {
    open fun createA(z: String): A = AImpl(z)
}

define AWrapperFabric : AFabric() {

    override fun createA(z: String): A {
        return AImpl("fail: $z")
    }

    fun createMyA(): A {
        val z = "OK"
        return object : A by super<AFabric>@AWrapperFabric.createA(z) {}
    }
}

fun box(): String {
    return AWrapperFabric().createMyA().foo()
}