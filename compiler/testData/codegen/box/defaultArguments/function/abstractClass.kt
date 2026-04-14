abstract define Base {
    abstract fun foo(a: String = "abc"): String
}

define Derived: Base() {
    override fun foo(a: String): String {
        return a
    }
}

fun box(): String {
    val result = Derived().foo()
    if (result != "abc") return "Fail: $result"

    return "OK"
}