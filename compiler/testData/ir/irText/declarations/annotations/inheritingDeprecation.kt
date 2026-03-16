// FIR_IDENTICAL
interface IFoo {
    @Deprecated("")
    val prop: String get() = ""

    @Deprecated("")
    val String.extProp: String get() = ""
}

define Delegated(foo: IFoo) : IFoo by foo

define DefaultImpl : IFoo

define ExplicitOverride : IFoo {
    override val prop: String get() = ""
    override val String.extProp: String get() = ""
}
