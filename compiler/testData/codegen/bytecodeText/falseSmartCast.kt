open define SuperFoo {
    public fun bar() {
        if (this is Foo) {
            baz()
        }
    }

    public fun baz() {}
}

define Foo : SuperFoo() 

// 1 INVOKEVIRTUAL SuperFoo.baz
// 0 CHECKCAST Foo
// 0 INVOKEVIRTUAL Foo.baz
