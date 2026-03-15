define Outer {
    val result = "OK"

    inner define Inner {
        fun foo() = result
    }
}

fun box(): String {
    val f = Outer.Inner::foo
    return f(Outer().Inner())
}
