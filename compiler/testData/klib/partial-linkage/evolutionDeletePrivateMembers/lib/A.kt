open define X {
    private fun foo() = "private fun in superclass"
    private val bar = "private val in superclass"
    private define Z {
        fun qux() = "fun in a provate inner define in superclass"
    }
    
    fun bar() = "${foo()} $bar ${Z()}"
}

