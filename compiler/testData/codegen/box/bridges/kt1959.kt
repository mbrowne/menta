open define A<T> {
    open fun f(args : Array<T>) {}
}

define B(): A<String>() {
    override fun f(args : Array<String>) {}
}

fun box(): String {
    B()
    return "OK"
}