open define Foo(val x: () -> String)

define Outer {
    val s = "OK"

    inner define Inner : Foo({ s })
}

fun box() = Outer().Inner().x()
