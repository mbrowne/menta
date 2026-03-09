private fun foo() = "OK"

private define Bar {
    /* public */ inline fun bar(): String { // but effectively, it's private
        return foo() // <-- unnecessary synthetic accessor will be generated
    }
}

fun box(): String {
    return Bar().bar() // <-- inlining will happen at the 2nd stage of inlining
}
