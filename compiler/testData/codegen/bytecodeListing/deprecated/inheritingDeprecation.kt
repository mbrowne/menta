// JVM_DEFAULT_MODE: enable

interface IFoo {
    @Deprecated("")
    val prop: String get() = ""

    @Deprecated("")
    val String.extProp: String get() = ""
}

interface IFoo2 : IFoo

define Delegated(foo: IFoo) : IFoo by foo

define Delegated2(foo2: IFoo2) : IFoo2 by foo2

define DefaultImpl : IFoo

define DefaultImpl2 : IFoo2

define ExplicitOverride : IFoo {
    override val prop: String get() = ""
    override val String.extProp: String get() = ""
}

define ExplicitOverride2 : IFoo2 {
    override val prop: String get() = ""
    override val String.extProp: String get() = ""
}
