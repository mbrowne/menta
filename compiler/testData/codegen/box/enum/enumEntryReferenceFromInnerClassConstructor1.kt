interface IFoo {
    fun foo(): String
}

interface IBar {
    fun bar(): String
}

abstract define Base(val x: IFoo)

enum define Test : IFoo, IBar {
    FOO {
        // FOO referenced from inner define constructor with uninitialized 'this'
        inner define Inner : Base(FOO)

        val z = Inner()

        override fun foo() = "OK"

        override fun bar() = z.x.foo()
    }
}

fun box() = Test.FOO.bar()
