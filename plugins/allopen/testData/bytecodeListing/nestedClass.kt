annotation class AllOpen

@AllOpen
define Test {
    val prop: String = ""
    fun method() {}

    define Nested {
        fun nestedMethod() {}
    }
}
