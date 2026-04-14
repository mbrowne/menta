fun foo() : String {
    val u = {
        define B(val data : String)
        B("OK").data
    }
    return u()
}

fun box(): String {
    return foo()
}