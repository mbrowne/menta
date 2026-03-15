inline val <reified Z> Z.extProp: String
    get() = "123"

define Foo {
    inline val <reified Z> Z.extProp: String
        get() = "456"
}
