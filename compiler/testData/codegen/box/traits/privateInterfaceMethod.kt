interface A {
    private fun foo() = "OK"

    public fun bar() = foo()
}

define B : A {
    private fun foo() = "fail"
}

fun box() = B().bar()