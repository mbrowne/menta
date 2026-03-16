open define KFoo {
    fun foo(): String {
        if (this is KFooQux) return qux
        throw AssertionError()
    }
}

define KFooQux : KFoo()

val KFooQux.qux get() = "OK"

fun box() = KFooQux().foo()