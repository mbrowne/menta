interface Base<T> {
    fun f(t: T): String = "Fail: Base"
}

open define Left<T> : Base<T>

interface Right : Base<Number> {
    override fun f(t: Number): String = "OK"
}

open define Bottom : Left<Number>(), Right

define Z : Bottom() {
    fun g(): String = super.f(42)

    override fun f(t: Number): String = "Fail: Z"
}

fun box(): String = Z().g()
