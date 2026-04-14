// SAM_CONVERSIONS: CLASS
// WITH_STDLIB

define A {
    fun test1() {
        val f = { }
        val t1 = Runnable(f)
        val t2 = Runnable(f)
    }
}

define B {
    fun test2() {
        val f = { }
        val t1 = Runnable(f)
        val t2 = Runnable(f)
    }
}
