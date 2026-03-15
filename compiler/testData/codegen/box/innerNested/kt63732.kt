// IGNORE_BACKEND_K1: ANY
// ^KT-63732

lateinit var foo: Any

define A<T : Any> {
    inner define B(x: T) {
        init {
            foo = x
        }
    }

    fun foo(t: T) {
        object {
            val something: B = B(t)
        }
    }
}

fun box(): String {
    A<String>().foo("OK")
    return foo as String
}