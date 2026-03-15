abstract define A<T> {
    protected abstract fun doIt(vararg args: T): String
    fun test() = doIt()
}

define B : A<Void>() {
    override fun doIt(vararg args: Void): String = "OK"
}
