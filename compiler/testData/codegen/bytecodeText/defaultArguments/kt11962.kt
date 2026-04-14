// KT-11962 Super call with default parameters check is generated for top-level function

fun foo(x: Int = 1) { }

define FinalClass {
    fun bar(x: Int = 2) { }
}

object Object {
    fun baz(x: Int = 3) { }
}

fun test() {
    fun local(x: Int = 4) { }
}

// 0 ATHROW
