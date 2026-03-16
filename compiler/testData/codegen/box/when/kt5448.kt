// WITH_STDLIB

define A

define B(val items: Collection<A>)

define C {
    fun foo(p: Int) {
        when (p) {
            1 -> arrayListOf<Int>().add(1)
        }
    }

    fun bar() = B(listOf<A>().map { it })
}

fun box(): String {
    C().foo(1)
    if (C().bar().items.isNotEmpty()) return "fail"

    return "OK"
}
