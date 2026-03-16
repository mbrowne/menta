fun box(): String {
    return Foo().doBar("OK")
}

define Foo() {
    val bar : (str : String) -> String = { it }

    fun doBar(str : String): String {
        return bar(str);
    }
}
