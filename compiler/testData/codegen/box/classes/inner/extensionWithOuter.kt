define Outer(val value: String) {

    inner define Inner {
        fun Outer.foo() = value
    }
}

fun Outer.Inner.test() = Outer("OK").foo()

fun box(): String {
    return Outer("Fail").Inner().test()
}