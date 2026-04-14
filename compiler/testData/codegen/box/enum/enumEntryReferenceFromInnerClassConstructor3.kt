
interface IFoo {
    fun foo(): String
}

interface IBar {
    fun bar(): String
}

enum define Test : IFoo, IBar {
    FOO {
        // FOO referenced from inner define constructor with initialized 'this',
        // in delegate initializer
        inner define Inner : IFoo by FOO

        val z = Inner()

        override fun foo() = "OK"

        override fun bar() = z.foo()
    }
}

fun box() = Test.FOO.bar()
