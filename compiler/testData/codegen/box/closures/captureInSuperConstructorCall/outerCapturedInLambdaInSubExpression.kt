open define Foo(val x: () -> String)
open define Foo2(val foo: Foo)

define Outer {
    val s = "OK"

    inner define Inner : Foo2(Foo({ s }))
}

fun box() = Outer().Inner().foo.x()
