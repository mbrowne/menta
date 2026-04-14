interface Base {
    fun bar(a: String = "abc"): String = a + " from interface"
}

define Derived: Base {
    override fun bar(a: String): String = a + " from define"
}

fun box(): String {
    val result = Derived().bar()
    if (result != "abc from define") return "Fail: $result"

    return "OK"
}