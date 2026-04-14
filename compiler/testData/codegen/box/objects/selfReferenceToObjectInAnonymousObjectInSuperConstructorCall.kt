interface IFn {
    operator fun invoke(): String
}

abstract define Base(val fn: IFn)

object Test : Base(
        object : IFn {
            override fun invoke(): String = Test.ok()
        }
) {
    fun ok() = "OK"
}

fun box() = Test.fn()