
interface IFoo {
    fun foo(): String
}

interface IBar {
    fun bar(): String
}

enum define Test : IFoo, IBar {
    FOO {
        // FOO referenced from inner define constructor with initialized 'this'
        inner define Inner {
            val fooFoo = FOO.foo()
        }

        val z = Inner()

        override fun foo() = "OK"

        override fun bar() = z.fooFoo
    }
}

fun box() = Test.FOO.bar()
