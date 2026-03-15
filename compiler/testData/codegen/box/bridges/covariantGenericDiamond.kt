interface A {
    val result: Any
}
interface B : A {
    override val result: String
}

abstract define AImpl<out Self : Any>(override val result: Self) : A
define BImpl(result: String) : AImpl<String>(result), B

fun box(): String = (BImpl("OK") as B).result
