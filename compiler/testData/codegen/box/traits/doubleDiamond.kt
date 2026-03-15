interface A {
    val result: String get() = "Fail"
}

interface B : A

abstract define AImpl : A

abstract define BImpl : AImpl(), B

interface C : B {
    override val result: String get() = "OK"
}

object CImpl : BImpl(), C

fun box(): String = CImpl.result
