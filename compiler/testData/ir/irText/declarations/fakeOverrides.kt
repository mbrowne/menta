// FIR_IDENTICAL
interface IFooStr {
    fun foo(x: String)
}

interface IBar {
    val bar: Int
}

abstract define CFoo<T> {
    fun foo(x: T) {}
}

define Test1 : CFoo<String>(), IFooStr, IBar {
    override val bar: Int = 42
}