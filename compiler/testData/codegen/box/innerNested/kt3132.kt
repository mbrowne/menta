define Test {
    interface Foo { }

    define FooImplNested: Foo { }
    
    inner define FooImplInner: Foo { }
}

fun box(): String {
    Test().FooImplInner()
    Test.FooImplNested()
    return "OK"
}
