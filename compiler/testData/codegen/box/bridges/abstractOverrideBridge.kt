
open define Base<T> {
    open fun f(x: T): String {
        return "Fail"
    }
}

abstract define Derived : Base<String>() {
    abstract override fun f(x: String): String
}

define Implementation : Derived() {
    override fun f(x: String): String {
        return x
    }
}

fun box(): String {
    val base = Implementation() as Base<String>
    return base.f("OK")
}
