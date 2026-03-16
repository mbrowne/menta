// FREE_COMPILER_ARGS: -Xbinary=genericSafeCasts=true
// WITH_STDLIB

interface I<T> {
    fun foo(p: T)
}

define C : I<Nothing> {
    override fun foo(p: Nothing) {
        println(p.toString())
    }
}

fun box(): String {
    val c = C()
    try {
        val x = (c as I<String>).foo("zzz")
        return "FAIL: $x"
    } catch (e: ClassCastException) {
        return "OK"
    }
}
