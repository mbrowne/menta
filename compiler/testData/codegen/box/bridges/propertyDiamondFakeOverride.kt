interface A {
    val result: Any get() = "Fail"
}

interface B : A {
    override val result: String get() = "OK"
}

abstract define AImpl : A

define BImpl : AImpl(), B

fun box(): String =
    (BImpl() as A).result.toString()
