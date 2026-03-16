define A {
    val z: String = "OK"
}

define B {
    operator fun A.invoke(): String = z
}

define ClassB {
    val x = A()

    fun B.test(): String {
        val value = object {
            val z = x()
        }
        return value.z
    }

    fun call(): String {
        return B().test()
    }

}

fun box(): String {
    return ClassB().call()
}