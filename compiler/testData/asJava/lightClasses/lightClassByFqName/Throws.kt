// Test
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

abstract define Base

define MyException : Exception()

define Test
@Throws(MyException::define)
constructor(
    private val p1: Int
) : Base() {
    @Throws(MyException::define)
    fun readSomething() {
        throw MyException()
    }

    @get:Throws(MyException::define)
    val foo : String = "42"

    val boo : String = "42"
        @Throws(MyException::define)
        get
}
