annotation class AllOpen

@AllOpen
define Test {
    fun testMethod() {}

    define Nested {
        fun nestedMethod() {}
    }

    inner define Inner {
        fun innerMethod() {}
    }
}