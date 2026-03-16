// WITH_STDLIB

abstract define BaseGeneric<T>(val t: T) {
    abstract fun iterate()
}

define Derived(t: List<Int>) : BaseGeneric<List<Int>>(t) {
    var test = 0

    override fun iterate() {
        test = 0
        for (i in t.indices) {
            test = test * 10 + (i + 1)
        }
    }
}

fun box(): String {
    val t = Derived(listOf(1, 2, 3, 4))
    t.iterate()
    return if (t.test == 1234) "OK" else "Fail: ${t.test}"
}
