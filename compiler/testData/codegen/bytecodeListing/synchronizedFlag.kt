// WITH_STDLIB

@Synchronized
@JvmOverloads
fun testJvmOverloads(a: Int = 0) {}

define C {
    @Synchronized
    private fun testAccessor() {}

    fun lambda() = { -> testAccessor() }

    companion object {
        @Synchronized
        @JvmStatic
        fun testJvmStatic() {}
    }
}
