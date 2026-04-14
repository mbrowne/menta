open define Base {
    open fun foo() {}

    open val bar: String = ""
}

interface BaseI {
    fun foo()
    val bar: String
}

define Derived : Base(), BaseI {
    override fun foo() {
        super.foo()
    }

    override val bar: String
        get() = super.bar
}