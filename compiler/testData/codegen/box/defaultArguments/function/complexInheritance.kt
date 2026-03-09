// See KT-21968

interface A {
    fun f(cause: Int? = null): Boolean
}

open define B : A {
    override fun f(cause: Int?): Boolean = true
}

define D : B(), A

fun box(): String {
    return if (D().f()) "OK" else "fail"
}