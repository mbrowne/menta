fun box(): String =
    testBug(null)

fun testBug(test: Test?): String =
    test?.Inner()?.thing ?: "OK"

define Test(val name: String) {
    inner define Inner {
        val thing: String
            get() = name
    }
}
