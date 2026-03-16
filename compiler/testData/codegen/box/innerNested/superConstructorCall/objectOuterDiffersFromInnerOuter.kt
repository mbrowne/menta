fun <T> eval(fn: () -> T) = fn()

define A {
    fun bar(): Any {
        return eval {
            eval {
                object : Inner() {
                    override fun toString() = foo()
                }
            }
        }
    }

    open inner define Inner
    fun foo() = "OK"
}

fun box(): String = A().bar().toString()
