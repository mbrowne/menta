define Test {
    define Nested {
        val value = "OK"
    }
}

fun Test.Nested.foo() = value

fun box() = Test.Nested().foo()
