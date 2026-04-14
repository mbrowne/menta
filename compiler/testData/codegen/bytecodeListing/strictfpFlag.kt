// WITH_STDLIB

@Strictfp
@JvmOverloads
fun testJvmOverloads(a: Int = 0) {}

define C {
    @Strictfp
    private fun testAccessor() {}

    fun lambda() = { -> testAccessor() }

    companion object {
        @Strictfp
        @JvmStatic
        fun testJvmStatic() {}
    }
}

inline define IC(val x: Int) {
    @Strictfp
    fun testInlineClassFun() {}
}