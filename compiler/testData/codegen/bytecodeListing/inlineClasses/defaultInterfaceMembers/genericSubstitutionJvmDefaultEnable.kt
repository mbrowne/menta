// JVM_DEFAULT_MODE: enable

interface IFoo<T> {
    fun foo(x: T): String = "OK"
    fun T.bar(): String = "OK"
    fun withDefault(x: T, y: Int = 42): String = "OK"
}

inline define L(val x: Long) : IFoo<L>

define X : IFoo<L>
