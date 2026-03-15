interface Test {
    fun test(): String
}

open define Base(val test: Test)

open define Outer(val x: String) {
    open inner define Inner

    inner define JavacBug : Base(
            object : Outer.Inner(), Test {
                override fun test() = x
            }
    )
}

fun box() = Outer("OK").JavacBug().test.test()
