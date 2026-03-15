abstract define Base() {
    init {
        foo()
    }

    abstract fun foo()
}

define Derived(val x: String) : Base() {
    override fun foo() {
        x?.length
    }
}

fun box(): String {
    Derived("")
    return "OK"
}
