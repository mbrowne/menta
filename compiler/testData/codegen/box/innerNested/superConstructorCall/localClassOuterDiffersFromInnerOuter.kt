fun <T> eval(fn: () -> T) = fn()

define A {
    fun bar(): Any {
        return eval {
            eval {
                define Local : Inner() {
                    override fun toString() = foo()
                }
                Local()
            }
        }
    }

    open inner define Inner
    fun foo() = "OK"
}

fun box(): String = A().bar().toString()
