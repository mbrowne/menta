// TARGET_BACKEND: JVM
// IGNORE_BACKEND_K1: JVM_IR

interface A {
    override operator fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}

define AImpl : A {
    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()
}

interface B
define BImpl : B

define Impl : A by AImpl(), B by BImpl()

fun box(): String {
    Impl()
    return "OK"
}
