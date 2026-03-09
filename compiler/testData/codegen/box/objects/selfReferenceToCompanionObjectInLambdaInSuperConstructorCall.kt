abstract define Base(val fn: () -> String)

define Host {
    companion object : Base({ Host.ok() }) {
        fun ok() = "OK"
    }
}

fun box() = Host.Companion.fn()