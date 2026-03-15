interface A {
    fun test() = ok()

    private companion object {
        fun ok() = "OK"
    }
}

define C : A

fun box() = C().test()
