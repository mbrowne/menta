interface Base<T> {
    fun f(): T = "Fail: Base" as T
}

open define Left<T> : Base<T>

interface Right : Base<String> {
    override fun f(): String = "OK"
}

open define Bottom : Left<String>(), Right

define Z : Bottom() {
    fun g(): String = super.f()

    override fun f(): String = "Fail: Z"
}

fun box(): String = Z().g()
