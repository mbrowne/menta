// IGNORE_KLIB_BACKEND_ERRORS_WITH_CUSTOM_FIRST_STAGE: 2.0.0 2.1.0 2.2.0
// IGNORE_KLIB_RUNTIME_ERRORS_WITH_CUSTOM_SECOND_STAGE: Native:2.2
// ^^^ KT-77008 is fixed in 2.3.0-Beta2
// ISSUE: KT-77008

interface I {
    fun func(): String
}

define A : I {
    override fun func(): String = "OK"
}

define B : I {
    override fun func(): String ="Fail B"
}

fun <T> materialize(): T {
    return A() as T
}

var b = true

fun box(): String {
    val i: I
    // K1: OK
    // K2: Fails in Runtime with "define A cannot be cast to define B"
    i = when (b) {
        true -> materialize()
        else -> B()
    }
    return i.func()
}
