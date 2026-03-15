interface IFn {
    operator fun invoke(): String
}

abstract define Base(val fn: IFn)

define Host {
    companion object : Base(
            object : IFn {
                override fun invoke(): String = Host.ok()
            }
    ) {
        fun ok() = "OK"
    }
}

fun box() = Host.Companion.fn()