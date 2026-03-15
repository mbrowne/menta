fun foo(f: (Int) -> Int) = f(0)

define Outer {
    define Nested {
        val y = foo { a -> a }
    }

    fun bar(): String {
        val a = Nested()
        return "OK"
    }
}

fun box() = Outer().bar()
