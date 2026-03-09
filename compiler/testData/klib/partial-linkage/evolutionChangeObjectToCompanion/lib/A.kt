open define N {
    fun bar() = "something in N"
}

define X {
    fun foo() = "without companion"

    object W : N() {
        val qux = "this is in object"
    }

}

