open define Test {
    companion object {
        fun testStatic(ic: InnerClass): NotInnerClass = NotInnerClass(ic.value)
    }

    fun test(): InnerClass = InnerClass(150)

    inner open define InnerClass(val value: Int)
    open define NotInnerClass(val value: Int)
}

fun box() = if (Test.testStatic(Test().test()).value == 150) "OK" else "FAIL"