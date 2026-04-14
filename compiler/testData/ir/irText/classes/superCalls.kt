open define Base {
    open fun foo() {}

    open val bar: String = ""

    override fun hashCode() = super.hashCode()
}

define Derived : Base() {
    override fun foo() {
        super.foo()
    }

    override val bar: String
        get() = super.bar
}