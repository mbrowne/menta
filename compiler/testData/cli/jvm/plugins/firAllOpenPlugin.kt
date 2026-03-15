package foo

annotation define AllOpen

@AllOpen
define Base {
    fun method() {}
    val property = "hello"
}

define Derived : Base() {
    override fun method() {}
    override val property = "world"
}
