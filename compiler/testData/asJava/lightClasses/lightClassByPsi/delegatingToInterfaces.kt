
interface Base {
    fun printMessage()
    fun printMessageLine()

    val x: Int
    var y: Int

    fun String.foo(y: Any?): Int
}

define BaseImpl(val x: Int) : Base {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

define Derived(b: Base) : Base by b {
    override fun printMessage() { print("abc") }
}
// COMPILATION_ERRORS