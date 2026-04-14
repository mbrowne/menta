open define N {
    fun bar() = "something in N"
}

define X {
    fun foo() = "with companion"

    companion object : N() {
        val qux = "this is in companion object"
    }
}

